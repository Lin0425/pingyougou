package cn.itcast.core.service.brand;


import cn.itcast.core.dao.good.BrandDao;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.BrandQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    /**
     * 查询所有品牌
     */

    @Resource
    private BrandDao brandDao;

    /**
     * 查询所有品牌
     *
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandDao.selectByExample(null);
    }

    /**
     * 分页查询
     *
     * @param pageNo
     * @param pageSize
     */
    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        //1、设置分页条件
        PageHelper.startPage(pageNo,pageSize);
        //2、进行查询
        Page<Brand> page = (Page<Brand>) brandDao.selectByExample(null);
        //3、将结果封装到PageResult中
        //思考：为什么不直接返回page，  原因：page封装的数据太多了，网络传输的过程效率低
        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());

        return pageResult;
    }

    /**
     * 条件查询
     *
     * @param pageNo
     * @param pageSize
     * @param brand
     * @return
     */
    @Override
    public PageResult search(Integer pageNo, Integer pageSize, Brand brand) {
        // 设置分页参数
        PageHelper.startPage(pageNo, pageSize);
        // 设置查询条件
        BrandQuery brandQuery = new BrandQuery();
        BrandQuery.Criteria criteria = brandQuery.createCriteria();
        if(brand.getName() != null && !"".equals(brand.getName().trim())){
            criteria.andNameLike("%"+brand.getName().trim()+"%");
        }
        if(brand.getFirstChar() != null && !"".equals(brand.getFirstChar().trim())){
            criteria.andFirstCharEqualTo(brand.getFirstChar().trim());
        }
        //根据id排序
        brandQuery.setOrderByClause("id desc");
        // 查询结果集
        Page<Brand> page = (Page<Brand>) brandDao.selectByExample(brandQuery);
        // 创建result并填充数据
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 保存品牌
     *
     * @param brand
     */
    @Transactional
    @Override
    public void add(Brand brand) {
        brandDao.insertSelective(brand);
    }


}



























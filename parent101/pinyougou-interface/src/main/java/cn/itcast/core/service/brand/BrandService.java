package cn.itcast.core.service.brand;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();

    /**
     * 分页查询
     */
    public PageResult findPage(Integer pageNo,Integer pageSize);


    /**
     * 条件查询
     * @param pageNo
     * @param pageSize
     * @param brand
     * @return
     */

    public PageResult search(Integer pageNo, Integer pageSize, Brand brand);


    /**
     * 保存品牌
     */
    public void add(Brand brand);


    /**
     * 回显品牌
     * @param id
     * @return
     */
    public Brand findOne(Long id);

    /**
     * 更新品牌
     */
    public void update(Brand brand);

    /**
     * 删除品牌
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 新增模板，初始化品牌的下拉框列表的数据
     * @return
     */
    public List<Map<String,String>> selectOptionList();

}




















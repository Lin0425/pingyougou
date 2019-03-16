package cn.itcast.core.service.brand;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;

import java.util.List;

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

}

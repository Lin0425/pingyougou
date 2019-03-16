package cn.itcast.core.controller.brand;


import cn.itcast.core.entity.PageResult;
import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.service.brand.BrandService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    /**
     * 查询所有品牌
     * @return
     */

    @RequestMapping("/findAll.do")
    public List<Brand> findAll(){
        List<Brand> brands = brandService.findAll();
        return brands ;
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/findPage.do")
    public PageResult findPage(Integer pageNo, Integer pageSize){
        return brandService.findPage(pageNo, pageSize);

    }


    /**
     * 条件查询
     * @param pageNo
     * @param pageSize
     * @param brand
     * @return
     */
    @RequestMapping("/search.do")
    public PageResult search(Integer pageNo, Integer pageSize, @RequestBody Brand brand){
        PageResult search = brandService.search(pageNo, pageSize, brand);
        return search;
    }

    @RequestMapping("/add.do")
    public Result add(@RequestBody Brand brand){

        try {
            brandService.add(brand);
            return new Result(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"保存失败");
        }
    }

}

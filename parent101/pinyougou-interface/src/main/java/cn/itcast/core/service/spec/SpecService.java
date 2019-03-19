package cn.itcast.core.service.spec;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.vo.SpecVo;

import java.util.List;
import java.util.Map;

public interface SpecService {

    /**
     * 规格列表查询
     * @param page
     * @param rows
     * @param specification
     * @return
     */
    public PageResult search(Integer page , Integer rows, Specification specification);


    /**
     * 保存规格
     * @param specVo
     */
    public void add(SpecVo specVo);

    /**
     * 规格回显
     * @param id
     * @return
     */
    public SpecVo findOne(Long id);

    /**
     * 修改规格
     * @param specVo
     */
    public void update(SpecVo specVo);

    /**
     * 删除规格
     */
    public void delete(Long[] ids);

    /**
     * 新增模板，初始化规格的下拉框列表的数据
     */
    public List<Map<String,String>> selectOptionList();

}

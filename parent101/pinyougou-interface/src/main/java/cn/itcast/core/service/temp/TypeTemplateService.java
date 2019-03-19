package cn.itcast.core.service.temp;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.template.TypeTemplate;

public interface TypeTemplateService {

    /**
     * 模板列表查询
     * @param page
     * @param rows
     * @param typeTemplate
     * @return
     */
    public PageResult search(Integer page, Integer rows, TypeTemplate typeTemplate);

    /**
     * 保存模板
     * @param typeTemplate
     */
    public void add (TypeTemplate typeTemplate);

    /**
     * 回显模板
     * @param id
     * @return
     */
    public TypeTemplate findOne(Long id);

    /**
     * 更新模板
     * @param typeTemplate
     */
    public void update(TypeTemplate typeTemplate);


    /**
     * 删除模板
     */
    public void delete(Long[] ids);

}





























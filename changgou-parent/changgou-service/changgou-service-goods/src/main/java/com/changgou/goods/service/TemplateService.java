package com.changgou.goods.service;

import com.changgou.goods.api.mapper.TbTemplateMapper;
import com.changgou.goods.api.pojo.TbTemplate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TemplateService {
    @Autowired
    private TbTemplateMapper templateMapper;
    /**
     * Template条件+分页查询
     * @param template 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */

    public PageInfo<TbTemplate> findPage(TbTemplate template, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(template);
        //执行搜索
        return new PageInfo<TbTemplate>(templateMapper.selectByExample(example));
    }

    /**
     * Template分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<TbTemplate> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TbTemplate>(templateMapper.selectAll());
    }

    /**
     * Template条件查询
     * @param template
     * @return
     */
    public List<TbTemplate> findList(TbTemplate template){
        //构建查询条件
        Example example = createExample(template);
        //根据构建的条件查询数据
        return templateMapper.selectByExample(example);
    }


    /**
     * Template构建查询对象
     * @param template
     * @return
     */
    public Example createExample(TbTemplate template){
        Example example=new Example(TbTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        if(template!=null){
            // ID
            if(template.getId() != null){
                criteria.andEqualTo("id",template.getId());
            }
            // 模板名称
            if(!StringUtils.isEmpty(template.getName())){
                criteria.andLike("name","%"+template.getName()+"%");
            }
            // 规格数量
            if(template.getSpecNum() != null){
                criteria.andEqualTo("specNum",template.getSpecNum());
            }
            // 参数数量
            if(template.getParaNum() != null){
                criteria.andEqualTo("paraNum",template.getParaNum());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id){
        templateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Template
     * @param template
     */
    public void update(TbTemplate template){
        templateMapper.updateByPrimaryKey(template);
    }

    /**
     * 增加Template
     * @param template
     */
    public void add(TbTemplate template){
        templateMapper.insert(template);
    }

    /**
     * 根据ID查询Template
     * @param id
     * @return
     */
    public TbTemplate findById(Integer id){
        return  templateMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Template全部数据
     * @return
     */
    public List<TbTemplate> findAll() {
        return templateMapper.selectAll();
    }
}

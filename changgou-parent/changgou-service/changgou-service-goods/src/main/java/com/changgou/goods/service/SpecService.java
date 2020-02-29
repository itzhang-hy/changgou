package com.changgou.goods.service;

import com.changgou.goods.api.mapper.TbSpecMapper;
import com.changgou.goods.api.mapper.TbTemplateMapper;
import com.changgou.goods.api.pojo.TbSpec;
import com.changgou.goods.api.pojo.TbTemplate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpecService {

    @Autowired
    private TbSpecMapper specMapper;

    @Autowired
    private TbTemplateMapper templateMapper;

    /**
     * Spec条件+分页查询
     * @param spec 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public PageInfo<TbSpec> findPage(TbSpec spec, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(spec);
        //执行搜索
        return new PageInfo<TbSpec>(specMapper.selectByExample(example));
    }

    /**
     * Spec分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<TbSpec> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TbSpec>(specMapper.selectAll());
    }

    /**
     * Spec条件查询
     * @param spec
     * @return
     */
    public List<TbSpec> findList(TbSpec spec){
        //构建查询条件
        Example example = createExample(spec);
        //根据构建的条件查询数据
        return specMapper.selectByExample(example);
    }


    /**
     * Spec构建查询对象
     * @param spec
     * @return
     */
    public Example createExample(TbSpec spec){
        Example example=new Example(TbSpec.class);
        Example.Criteria criteria = example.createCriteria();
        if(spec!=null){
            // ID
            if(spec.getId() != null){
                criteria.andEqualTo("id",spec.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(spec.getName())){
                criteria.andLike("name","%"+spec.getName()+"%");
            }
            // 规格选项
            if(!StringUtils.isEmpty(spec.getOptions())){
                criteria.andEqualTo("options",spec.getOptions());
            }
            // 排序
            if(spec.getSeq() != null){
                criteria.andEqualTo("seq",spec.getSeq());
            }
            // 模板ID
            if(spec.getTemplateId() != null){
                criteria.andEqualTo("templateId",spec.getTemplateId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id){
        //查询模板
        TbSpec spec = specMapper.selectByPrimaryKey(id);
        //变更模板数量
        updateSpecNum(spec,-1);

        //删除指定规格
        specMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Spec
     * @param spec
     */
    public void update(TbSpec spec){
        specMapper.updateByPrimaryKey(spec);
    }

    /**
     * 增加Spec
     * @param spec
     */
    public void add(TbSpec spec){
        specMapper.insert(spec);
        //变更模板数量
        updateSpecNum(spec,1);
    }

    /**
     * 根据ID查询Spec
     * @param id
     * @return
     */
    public TbSpec findById(Integer id){
        return  specMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Spec全部数据
     * @return
     */
    public List<TbSpec> findAll() {
        return specMapper.selectAll();
    }


    /**
     * 修改模板统计数据
     * @param spec:操作的模板
     * @param count:变更的数量
     */
    public void updateSpecNum(TbSpec spec, Integer count){
        //修改模板数量统计
        TbTemplate template = templateMapper.selectByPrimaryKey(spec.getTemplateId());
        template.setSpecNum(template.getSpecNum()+count);
        templateMapper.updateByPrimaryKeySelective(template);
    }
}

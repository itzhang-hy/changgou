package com.changgou.goods.service;

import com.changgou.goods.api.mapper.TbParaMapper;
import com.changgou.goods.api.mapper.TbTemplateMapper;
import com.changgou.goods.api.pojo.TbPara;
import com.changgou.goods.api.pojo.TbTemplate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ParaService {

    @Autowired
    private TbParaMapper paraMapper;

    @Autowired
    private TbTemplateMapper templateMapper;

    /**
     * Para条件+分页查询
     * @param para 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public PageInfo<TbPara> findPage(TbPara para, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(para);
        //执行搜索
        return new PageInfo<TbPara>(paraMapper.selectByExample(example));
    }

    /**
     * Para分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<TbPara> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TbPara>(paraMapper.selectAll());
    }

    /**
     * Para条件查询
     * @param para
     * @return
     */
    public List<TbPara> findList(TbPara para){
        //构建查询条件
        Example example = createExample(para);
        //根据构建的条件查询数据
        return paraMapper.selectByExample(example);
    }


    /**
     * Para构建查询对象
     * @param para
     * @return
     */
    public Example createExample(TbPara para){
        Example example=new Example(TbPara.class);
        Example.Criteria criteria = example.createCriteria();
        if(para!=null){
            // id
            if(para.getId() != null){
                criteria.andEqualTo("id",para.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(para.getName())){
                criteria.andLike("name","%"+para.getName()+"%");
            }
            // 选项
            if(!StringUtils.isEmpty(para.getOptions())){
                criteria.andEqualTo("options",para.getOptions());
            }
            // 排序
            if(para.getSeq() != null){
                criteria.andEqualTo("seq",para.getSeq());
            }
            // 模板ID
            if(para.getTemplateId() != null){
                criteria.andEqualTo("templateId",para.getTemplateId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id){
        //根据ID查询
        TbPara para = paraMapper.selectByPrimaryKey(id);
        //修改模板统计数据
        updateParaNum(para,-1);

        paraMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Para
     * @param para
     */
    public void update(TbPara para){
        paraMapper.updateByPrimaryKey(para);
    }

    /**
     * 增加Para
     * @param para
     */
    public void add(TbPara para){
        paraMapper.insert(para);

        //修改模板统计数据
        updateParaNum(para,1);
    }

    /**
     * 根据ID查询Para
     * @param id
     * @return
     */
    public TbPara findById(Integer id){
        return  paraMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Para全部数据
     * @return
     */
    public List<TbPara> findAll() {
        return paraMapper.selectAll();
    }

    /**
     * 修改模板统计数据
     * @param para:操作的参数
     * @param count:变更的数量
     */
    public void updateParaNum(TbPara para, int count){
        //修改模板数量统计
        TbTemplate template = templateMapper.selectByPrimaryKey(para.getTemplateId());
        template.setParaNum(template.getParaNum()+count);
        templateMapper.updateByPrimaryKeySelective(template);
    }
}

package com.changgou.goods.service;

import com.changgou.goods.api.mapper.TbCategoryMapper;
import com.changgou.goods.api.pojo.TbCategory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private TbCategoryMapper categoryMapper;

    /**
     * Category条件+分页查询
     * @param category 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public PageInfo<TbCategory> findPage(TbCategory category, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(category);
        //执行搜索
        return new PageInfo<TbCategory>(categoryMapper.selectByExample(example));
    }

    /**
     * Category分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<TbCategory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TbCategory>(categoryMapper.selectAll());
    }

    /**
     * Category条件查询
     * @param category
     * @return
     */
    public List<TbCategory> findList(TbCategory category){
        //构建查询条件
        Example example = createExample(category);
        //根据构建的条件查询数据
        return categoryMapper.selectByExample(example);
    }


    /**
     * Category构建查询对象
     * @param category
     * @return
     */
    public Example createExample(TbCategory category){
        Example example=new Example(TbCategory.class);
        Example.Criteria criteria = example.createCriteria();
        if(category!=null){
            // 分类ID
            if(category.getId() != null){
                criteria.andEqualTo("id",category.getId());
            }
            // 分类名称
            if(!StringUtils.isEmpty(category.getName())){
                criteria.andLike("name","%"+category.getName()+"%");
            }
            // 商品数量
            if(category.getGoodsNum() != null){
                criteria.andEqualTo("goodsNum",category.getGoodsNum());
            }
            // 是否显示
            if(!StringUtils.isEmpty(category.getIsShow())){
                criteria.andEqualTo("isShow",category.getIsShow());
            }
            // 是否导航
            if(!StringUtils.isEmpty(category.getIsMenu())){
                criteria.andEqualTo("isMenu",category.getIsMenu());
            }
            // 排序
            if(category.getSeq() != null){
                criteria.andEqualTo("seq",category.getSeq());
            }
            // 上级ID
            if(category.getParentId() != null){
                criteria.andEqualTo("parentId",category.getParentId());
            }
            // 模板ID
            if(category.getTemplateId() != null){
                criteria.andEqualTo("templateId",category.getTemplateId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id){
        categoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Category
     * @param category
     */
    public void update(TbCategory category){
        categoryMapper.updateByPrimaryKey(category);
    }

    /**
     * 增加Category
     * @param category
     */
    public void add(TbCategory category){
        categoryMapper.insert(category);
    }

    /**
     * 根据ID查询Category
     * @param id
     * @return
     */
    public TbCategory findById(Integer id){
        return  categoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Category全部数据
     * @return
     */
    public List<TbCategory> findAll() {
        return categoryMapper.selectAll();
    }

    /***
     * 根据父节点ID查询
     * @param pid:父节点ID
     */
    public List<TbCategory> findByParentId(Integer pid) {
        TbCategory category = new TbCategory();
        category.setParentId(pid);
        return categoryMapper.select(category);
    }
}

package com.changgou.goods.service;

import com.changgou.goods.api.mapper.TbBrandMapper;
import com.changgou.goods.api.pojo.TbBrand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 条件+分页查询
     * @param tbBrand 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public PageInfo<TbBrand> findPage(TbBrand tbBrand, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(tbBrand);
        //执行搜索
        return new PageInfo<TbBrand>(tbBrandMapper.selectByExample(example));
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<TbBrand> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TbBrand>(tbBrandMapper.selectAll());
    }

    /**
     * 条件查询
     * @param tbBrand
     * @return
     */
    public List<TbBrand> findList(TbBrand tbBrand){
        Example example = createExample(tbBrand);
        return tbBrandMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param brand
     * @return
     */
    public Example createExample(TbBrand brand){
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            // 品牌名称
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            // 品牌图片地址
            if(!StringUtils.isEmpty(brand.getImage())){
                criteria.andLike("image","%"+brand.getImage()+"%");
            }
            // 品牌的首字母
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andLike("letter","%"+brand.getLetter()+"%");
            }
            // 品牌id
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("id",brand.getId());
            }
            // 排序
            /*if(!StringUtils.isEmpty(brand.getSeq())){
                criteria.andEqualTo("seq",brand.getSeq());
            }*/
            return example;
        }
        return null;
    }
    /***
     * 删除Brand
     * @param id
     */
    public Boolean delete(Integer id){
        if(tbBrandMapper.deleteByPrimaryKey(id) > 0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 根据id修改Brand
     * @param tbBrand
     * @return
     */
    public Boolean update(TbBrand tbBrand){
        if(tbBrandMapper.updateByPrimaryKeySelective(tbBrand) > 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 添加Brand
     * @param tbBrand
     * @return
     */
    public Boolean add(TbBrand tbBrand){
        if(tbBrandMapper.insertSelective(tbBrand) > 0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 查询所有品牌
     * @return
     */
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectAll();
    }
    /**
     * 根据ID查询单个品牌
     * @param brandId
     * @return
     */
    public TbBrand fingById(Integer brandId){
        return tbBrandMapper.selectByPrimaryKey(brandId);
    }
}

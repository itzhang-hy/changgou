package com.changgou.goods.api.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_category_brand")
public class TbCategoryBrand {
    /**
     * 分类ID
     */
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 品牌ID
     */
    @Id
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取品牌ID
     *
     * @return brand_id - 品牌ID
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌ID
     *
     * @param brandId 品牌ID
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
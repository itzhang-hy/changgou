package com.changgou.goods.api.pojo;

import javax.persistence.*;

@Table(name = "tb_spu")
public class TbSpu {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 货号
     */
    private String sn;

    /**
     * SPU名
     */
    private String name;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 一级分类
     */
    @Column(name = "category1_id")
    private Integer category1Id;

    /**
     * 二级分类
     */
    @Column(name = "category2_id")
    private Integer category2Id;

    /**
     * 三级分类
     */
    @Column(name = "category3_id")
    private Integer category3Id;

    /**
     * 模板ID
     */
    @Column(name = "template_id")
    private Integer templateId;

    /**
     * 运费模板id
     */
    @Column(name = "freight_id")
    private Integer freightId;

    /**
     * 图片
     */
    private String image;

    /**
     * 图片列表
     */
    private String images;

    /**
     * 售后服务
     */
    @Column(name = "sale_service")
    private String saleService;

    /**
     * 规格列表
     */
    @Column(name = "spec_items")
    private String specItems;

    /**
     * 参数列表
     */
    @Column(name = "para_items")
    private String paraItems;

    /**
     * 销量
     */
    @Column(name = "sale_num")
    private Integer saleNum;

    /**
     * 评论数
     */
    @Column(name = "comment_num")
    private Integer commentNum;

    /**
     * 是否上架
     */
    @Column(name = "is_marketable")
    private String isMarketable;

    /**
     * 是否启用规格
     */
    @Column(name = "is_enable_spec")
    private String isEnableSpec;

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private String isDelete;

    /**
     * 审核状态
     */
    private String status;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取货号
     *
     * @return sn - 货号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置货号
     *
     * @param sn 货号
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取SPU名
     *
     * @return name - SPU名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置SPU名
     *
     * @param name SPU名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取副标题
     *
     * @return caption - 副标题
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 设置副标题
     *
     * @param caption 副标题
     */
    public void setCaption(String caption) {
        this.caption = caption;
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

    /**
     * 获取一级分类
     *
     * @return category1_id - 一级分类
     */
    public Integer getCategory1Id() {
        return category1Id;
    }

    /**
     * 设置一级分类
     *
     * @param category1Id 一级分类
     */
    public void setCategory1Id(Integer category1Id) {
        this.category1Id = category1Id;
    }

    /**
     * 获取二级分类
     *
     * @return category2_id - 二级分类
     */
    public Integer getCategory2Id() {
        return category2Id;
    }

    /**
     * 设置二级分类
     *
     * @param category2Id 二级分类
     */
    public void setCategory2Id(Integer category2Id) {
        this.category2Id = category2Id;
    }

    /**
     * 获取三级分类
     *
     * @return category3_id - 三级分类
     */
    public Integer getCategory3Id() {
        return category3Id;
    }

    /**
     * 设置三级分类
     *
     * @param category3Id 三级分类
     */
    public void setCategory3Id(Integer category3Id) {
        this.category3Id = category3Id;
    }

    /**
     * 获取模板ID
     *
     * @return template_id - 模板ID
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板ID
     *
     * @param templateId 模板ID
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取运费模板id
     *
     * @return freight_id - 运费模板id
     */
    public Integer getFreightId() {
        return freightId;
    }

    /**
     * 设置运费模板id
     *
     * @param freightId 运费模板id
     */
    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    /**
     * 获取图片
     *
     * @return image - 图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片
     *
     * @param image 图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取图片列表
     *
     * @return images - 图片列表
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置图片列表
     *
     * @param images 图片列表
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取售后服务
     *
     * @return sale_service - 售后服务
     */
    public String getSaleService() {
        return saleService;
    }

    /**
     * 设置售后服务
     *
     * @param saleService 售后服务
     */
    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    /**
     * 获取规格列表
     *
     * @return spec_items - 规格列表
     */
    public String getSpecItems() {
        return specItems;
    }

    /**
     * 设置规格列表
     *
     * @param specItems 规格列表
     */
    public void setSpecItems(String specItems) {
        this.specItems = specItems;
    }

    /**
     * 获取参数列表
     *
     * @return para_items - 参数列表
     */
    public String getParaItems() {
        return paraItems;
    }

    /**
     * 设置参数列表
     *
     * @param paraItems 参数列表
     */
    public void setParaItems(String paraItems) {
        this.paraItems = paraItems;
    }

    /**
     * 获取销量
     *
     * @return sale_num - 销量
     */
    public Integer getSaleNum() {
        return saleNum;
    }

    /**
     * 设置销量
     *
     * @param saleNum 销量
     */
    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    /**
     * 获取评论数
     *
     * @return comment_num - 评论数
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * 设置评论数
     *
     * @param commentNum 评论数
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * 获取是否上架
     *
     * @return is_marketable - 是否上架
     */
    public String getIsMarketable() {
        return isMarketable;
    }

    /**
     * 设置是否上架
     *
     * @param isMarketable 是否上架
     */
    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    /**
     * 获取是否启用规格
     *
     * @return is_enable_spec - 是否启用规格
     */
    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    /**
     * 设置是否启用规格
     *
     * @param isEnableSpec 是否启用规格
     */
    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    /**
     * 获取是否删除
     *
     * @return is_delete - 是否删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取审核状态
     *
     * @return status - 审核状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置审核状态
     *
     * @param status 审核状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取介绍
     *
     * @return introduction - 介绍
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置介绍
     *
     * @param introduction 介绍
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
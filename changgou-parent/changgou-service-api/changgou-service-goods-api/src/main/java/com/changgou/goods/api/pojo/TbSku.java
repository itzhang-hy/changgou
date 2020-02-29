package com.changgou.goods.api.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_sku")
public class TbSku {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 商品条码
     */
    private String sn;

    /**
     * SKU名称
     */
    private String name;

    /**
     * 价格（分）
     */
    private Integer price;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 库存预警数量
     */
    @Column(name = "alert_num")
    private Integer alertNum;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 商品图片列表
     */
    private String images;

    /**
     * 重量（克）
     */
    private Integer weight;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * SPUID
     */
    @Column(name = "spu_id")
    private String spuId;

    /**
     * 类目ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 类目名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 品牌名称
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * 规格
     */
    private String spec;

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
     * 商品状态 1-正常，2-下架，3-删除
     */
    private String status;

    private Integer version;

    /**
     * 获取商品id
     *
     * @return id - 商品id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置商品id
     *
     * @param id 商品id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取商品条码
     *
     * @return sn - 商品条码
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置商品条码
     *
     * @param sn 商品条码
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取SKU名称
     *
     * @return name - SKU名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置SKU名称
     *
     * @param name SKU名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取价格（分）
     *
     * @return price - 价格（分）
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置价格（分）
     *
     * @param price 价格（分）
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取库存数量
     *
     * @return num - 库存数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置库存数量
     *
     * @param num 库存数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取库存预警数量
     *
     * @return alert_num - 库存预警数量
     */
    public Integer getAlertNum() {
        return alertNum;
    }

    /**
     * 设置库存预警数量
     *
     * @param alertNum 库存预警数量
     */
    public void setAlertNum(Integer alertNum) {
        this.alertNum = alertNum;
    }

    /**
     * 获取商品图片
     *
     * @return image - 商品图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置商品图片
     *
     * @param image 商品图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取商品图片列表
     *
     * @return images - 商品图片列表
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置商品图片列表
     *
     * @param images 商品图片列表
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取重量（克）
     *
     * @return weight - 重量（克）
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置重量（克）
     *
     * @param weight 重量（克）
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取SPUID
     *
     * @return spu_id - SPUID
     */
    public String getSpuId() {
        return spuId;
    }

    /**
     * 设置SPUID
     *
     * @param spuId SPUID
     */
    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    /**
     * 获取类目ID
     *
     * @return category_id - 类目ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类目ID
     *
     * @param categoryId 类目ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取类目名称
     *
     * @return category_name - 类目名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置类目名称
     *
     * @param categoryName 类目名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取品牌名称
     *
     * @return brand_name - 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取规格
     *
     * @return spec - 规格
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 设置规格
     *
     * @param spec 规格
     */
    public void setSpec(String spec) {
        this.spec = spec;
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
     * 获取商品状态 1-正常，2-下架，3-删除
     *
     * @return status - 商品状态 1-正常，2-下架，3-删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置商品状态 1-正常，2-下架，3-删除
     *
     * @param status 商品状态 1-正常，2-下架，3-删除
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
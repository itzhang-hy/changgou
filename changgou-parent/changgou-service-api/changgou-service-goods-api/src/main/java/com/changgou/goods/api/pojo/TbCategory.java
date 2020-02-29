package com.changgou.goods.api.pojo;

import javax.persistence.*;

@Table(name = "tb_category")
public class TbCategory {
    /**
     * 分类ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 商品数量
     */
    @Column(name = "goods_num")
    private Integer goodsNum;

    /**
     * 是否显示
     */
    @Column(name = "is_show")
    private String isShow;

    /**
     * 是否导航
     */
    @Column(name = "is_menu")
    private String isMenu;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 上级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 模板ID
     */
    @Column(name = "template_id")
    private Integer templateId;

    /**
     * 获取分类ID
     *
     * @return id - 分类ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置分类ID
     *
     * @param id 分类ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取商品数量
     *
     * @return goods_num - 商品数量
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 设置商品数量
     *
     * @param goodsNum 商品数量
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 获取是否显示
     *
     * @return is_show - 是否显示
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示
     *
     * @param isShow 是否显示
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取是否导航
     *
     * @return is_menu - 是否导航
     */
    public String getIsMenu() {
        return isMenu;
    }

    /**
     * 设置是否导航
     *
     * @param isMenu 是否导航
     */
    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    /**
     * 获取排序
     *
     * @return seq - 排序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置排序
     *
     * @param seq 排序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取上级ID
     *
     * @return parent_id - 上级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级ID
     *
     * @param parentId 上级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
}
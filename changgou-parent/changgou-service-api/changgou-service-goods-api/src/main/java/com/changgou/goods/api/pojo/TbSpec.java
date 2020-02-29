package com.changgou.goods.api.pojo;

import javax.persistence.*;

@Table(name = "tb_spec")
public class TbSpec {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 规格选项
     */
    private String options;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 模板ID
     */
    @Column(name = "template_id")
    private Integer templateId;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取规格选项
     *
     * @return options - 规格选项
     */
    public String getOptions() {
        return options;
    }

    /**
     * 设置规格选项
     *
     * @param options 规格选项
     */
    public void setOptions(String options) {
        this.options = options;
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
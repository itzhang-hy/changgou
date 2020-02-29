package com.changgou.goods.api.pojo;

import javax.persistence.*;

@Table(name = "tb_template")
public class TbTemplate {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 规格数量
     */
    @Column(name = "spec_num")
    private Integer specNum;

    /**
     * 参数数量
     */
    @Column(name = "para_num")
    private Integer paraNum;

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
     * 获取模板名称
     *
     * @return name - 模板名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置模板名称
     *
     * @param name 模板名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取规格数量
     *
     * @return spec_num - 规格数量
     */
    public Integer getSpecNum() {
        return specNum;
    }

    /**
     * 设置规格数量
     *
     * @param specNum 规格数量
     */
    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }

    /**
     * 获取参数数量
     *
     * @return para_num - 参数数量
     */
    public Integer getParaNum() {
        return paraNum;
    }

    /**
     * 设置参数数量
     *
     * @param paraNum 参数数量
     */
    public void setParaNum(Integer paraNum) {
        this.paraNum = paraNum;
    }
}
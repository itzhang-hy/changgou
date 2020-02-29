package com.changgou.goods.api.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_pref")
public class TbPref {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类ID
     */
    @Column(name = "cate_id")
    private Integer cateId;

    /**
     * 消费金额
     */
    @Column(name = "buy_money")
    private Integer buyMoney;

    /**
     * 优惠金额
     */
    @Column(name = "pre_money")
    private Integer preMoney;

    /**
     * 活动开始日期
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 活动截至日期
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态
     */
    private String state;

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
     * 获取分类ID
     *
     * @return cate_id - 分类ID
     */
    public Integer getCateId() {
        return cateId;
    }

    /**
     * 设置分类ID
     *
     * @param cateId 分类ID
     */
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    /**
     * 获取消费金额
     *
     * @return buy_money - 消费金额
     */
    public Integer getBuyMoney() {
        return buyMoney;
    }

    /**
     * 设置消费金额
     *
     * @param buyMoney 消费金额
     */
    public void setBuyMoney(Integer buyMoney) {
        this.buyMoney = buyMoney;
    }

    /**
     * 获取优惠金额
     *
     * @return pre_money - 优惠金额
     */
    public Integer getPreMoney() {
        return preMoney;
    }

    /**
     * 设置优惠金额
     *
     * @param preMoney 优惠金额
     */
    public void setPreMoney(Integer preMoney) {
        this.preMoney = preMoney;
    }

    /**
     * 获取活动开始日期
     *
     * @return start_time - 活动开始日期
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置活动开始日期
     *
     * @param startTime 活动开始日期
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取活动截至日期
     *
     * @return end_time - 活动截至日期
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置活动截至日期
     *
     * @param endTime 活动截至日期
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }
}
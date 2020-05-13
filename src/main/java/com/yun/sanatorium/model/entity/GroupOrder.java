package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "group_order")
public class GroupOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 团购状态
     */
    private String state;

    /**
     * 团购人数
     */
    private Integer number;

    /**
     * 单价
     */
    private String price;

    /**
     * 开团时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取团购状态
     *
     * @return state - 团购状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置团购状态
     *
     * @param state 团购状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取团购人数
     *
     * @return number - 团购人数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置团购人数
     *
     * @param number 团购人数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取开团时间
     *
     * @return start_time - 开团时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开团时间
     *
     * @param startTime 开团时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
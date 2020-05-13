package com.yun.sanatorium.model.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "service_item")
public class ServiceItem {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 简介
     */
    private String synopsis;

    /**
     * 时长
     */
    private Integer duration;

    /**
     * 服务类别id
     */
    @Column(name = "service_category_id")
    private String serviceCategoryId;

    /**
     * 服务类别名称
     */
    @Column(name = "service_category_name")
    private String serviceCategoryName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 团购状态
     */
    @Column(name = "group_buy_status")
    private String groupBuyStatus;

    /**
     * 排序
     */
    private Integer sort;

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
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取服务名称
     *
     * @return name - 服务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置服务名称
     *
     * @param name 服务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取简介
     *
     * @return synopsis - 简介
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * 设置简介
     *
     * @param synopsis 简介
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * 获取时长
     *
     * @return duration - 时长
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 设置时长
     *
     * @param duration 时长
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 获取服务类别id
     *
     * @return service_category_id - 服务类别id
     */
    public String getServiceCategoryId() {
        return serviceCategoryId;
    }

    /**
     * 设置服务类别id
     *
     * @param serviceCategoryId 服务类别id
     */
    public void setServiceCategoryId(String serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    /**
     * 获取服务类别名称
     *
     * @return service_category_name - 服务类别名称
     */
    public String getServiceCategoryName() {
        return serviceCategoryName;
    }

    /**
     * 设置服务类别名称
     *
     * @param serviceCategoryName 服务类别名称
     */
    public void setServiceCategoryName(String serviceCategoryName) {
        this.serviceCategoryName = serviceCategoryName;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取积分
     *
     * @return integral - 积分
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 设置积分
     *
     * @param integral 积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * 获取团购状态
     *
     * @return group_buy_status - 团购状态
     */
    public String getGroupBuyStatus() {
        return groupBuyStatus;
    }

    /**
     * 设置团购状态
     *
     * @param groupBuyStatus 团购状态
     */
    public void setGroupBuyStatus(String groupBuyStatus) {
        this.groupBuyStatus = groupBuyStatus;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
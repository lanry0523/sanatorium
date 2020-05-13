package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "group_order_user")
public class GroupOrderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 团购成员id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 团购订单id
     */
    @Column(name = "order_id")
    private String orderId;

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
     * 获取团购成员id
     *
     * @return user_id - 团购成员id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置团购成员id
     *
     * @param userId 团购成员id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取团购订单id
     *
     * @return order_id - 团购订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置团购订单id
     *
     * @param orderId 团购订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户优惠券关联表
 */
@Data
@Table(name = "coupon_user")
public class CouponUser {
    /**
     * UUID
     */
    @Id
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 关联id
     */
    private String relationId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 优惠券状态(0 未使用 ,1 已使用,2 已过期)
     */
    private String couponStatus;
    /**
     * 优惠券截止日期
     */
    private String couponEndTime;
}
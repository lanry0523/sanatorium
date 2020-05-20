package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.*;

/***
 * 优惠券表
 */
@Data
@Table(name = "coupon")
public class Coupon {
    /**
     * uuid
     */
    @Id
    private String id;

    /**
     * 代金券,优惠券
     */
    private Integer type;

    /**
     * 优惠券标题
     */
    private String title;

    /**
     * 发放优惠券的总数量
     */
    private Integer number;

    /**
     * 需满金额可用 0为不限制
     */
    private String amountAvailable;

    /**
     * 优惠金额 如果是优惠券，填写8.5就是85折，代金券直接填写金额 
     */
    private String couponAmount;

    /**
     * 有效期开始
     */
    private String effectiveTimeStart;
    /**
     * 有效期结束
     */
    private String effectiveTimeEnd;

    /**
     * 兑换一张需要多少分，如果不需要用积分兑换填写0即可（优惠券标题里最好标注类似500积分兑换50元代金券）
     */
    private Integer points;

    /**
     * 排序 数值越大越靠前 
     */
    private Integer sort;

    /**
     * 仅新用户可领取
     */
    private Integer isReceive;

}
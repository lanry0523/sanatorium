package com.yun.sanatorium.model.entity;

import javax.persistence.*;

public class Coupon {
    /**
     * uuid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "amount_available")
    private String amountAvailable;

    /**
     * 优惠金额 如果是优惠券，填写8.5就是85折，代金券直接填写金额 
     */
    @Column(name = "coupon_amount")
    private String couponAmount;

    /**
     * 有效期
     */
    @Column(name = "effective_time")
    private String effectiveTime;

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
    @Column(name = "is_receive")
    private Integer isReceive;

    /**
     * 获取uuid
     *
     * @return id - uuid
     */
    public String getId() {
        return id;
    }

    /**
     * 设置uuid
     *
     * @param id uuid
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取代金券,优惠券
     *
     * @return type - 代金券,优惠券
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置代金券,优惠券
     *
     * @param type 代金券,优惠券
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取优惠券标题
     *
     * @return title - 优惠券标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置优惠券标题
     *
     * @param title 优惠券标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取发放优惠券的总数量
     *
     * @return number - 发放优惠券的总数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置发放优惠券的总数量
     *
     * @param number 发放优惠券的总数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取需满金额可用 0为不限制
     *
     * @return amount_available - 需满金额可用 0为不限制
     */
    public String getAmountAvailable() {
        return amountAvailable;
    }

    /**
     * 设置需满金额可用 0为不限制
     *
     * @param amountAvailable 需满金额可用 0为不限制
     */
    public void setAmountAvailable(String amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    /**
     * 获取优惠金额 如果是优惠券，填写8.5就是85折，代金券直接填写金额 
     *
     * @return coupon_amount - 优惠金额 如果是优惠券，填写8.5就是85折，代金券直接填写金额 
     */
    public String getCouponAmount() {
        return couponAmount;
    }

    /**
     * 设置优惠金额 如果是优惠券，填写8.5就是85折，代金券直接填写金额 
     *
     * @param couponAmount 优惠金额 如果是优惠券，填写8.5就是85折，代金券直接填写金额 
     */
    public void setCouponAmount(String couponAmount) {
        this.couponAmount = couponAmount;
    }

    /**
     * 获取有效期
     *
     * @return effective_time - 有效期
     */
    public String getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * 设置有效期
     *
     * @param effectiveTime 有效期
     */
    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * 获取兑换一张需要多少分，如果不需要用积分兑换填写0即可（优惠券标题里最好标注类似500积分兑换50元代金券）
     *
     * @return points - 兑换一张需要多少分，如果不需要用积分兑换填写0即可（优惠券标题里最好标注类似500积分兑换50元代金券）
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置兑换一张需要多少分，如果不需要用积分兑换填写0即可（优惠券标题里最好标注类似500积分兑换50元代金券）
     *
     * @param points 兑换一张需要多少分，如果不需要用积分兑换填写0即可（优惠券标题里最好标注类似500积分兑换50元代金券）
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取排序 数值越大越靠前 
     *
     * @return sort - 排序 数值越大越靠前 
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序 数值越大越靠前 
     *
     * @param sort 排序 数值越大越靠前 
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取仅新用户可领取
     *
     * @return is_receive - 仅新用户可领取
     */
    public Integer getIsReceive() {
        return isReceive;
    }

    /**
     * 设置仅新用户可领取
     *
     * @param isReceive 仅新用户可领取
     */
    public void setIsReceive(Integer isReceive) {
        this.isReceive = isReceive;
    }
}
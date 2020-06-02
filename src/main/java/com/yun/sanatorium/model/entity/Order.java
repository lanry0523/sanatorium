package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Table(name="orders")
public class Order {
    /**
     * UUID
     */
    @Id
    private String id;

    /**
     * 门店名称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 预约项目
     */
    @Column(name = "appointment_project")
    private String appointmentProject;

    /**
     * 订单金额
     */
    private String amount;

    /**
     * 折扣
     */
    private String discount;

    /**
     * 优惠券抵用
     */
    @Column(name = "coupon_credit")
    private String couponCredit;

    /**
     * 实付金额
     */
    @Column(name = "pay_amount")
    private String payAmount;

    /**
     * 到店时间
     */
    @Column(name = "arrival_time")
    private String arrivalTime;

    /**
     * 项目时长
     */
    @Column(name = "project_time")
    private String projectTime;

    /**
     * 下单时间，创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 支付方式
     */
    @Column(name = "payment_type")
    private Integer paymentType;

    /**
     * 服务人员
     */
    @Column(name = "personal_id")
    private String personalId;

    /**
     * 订单状态
     */
    private Integer state;

    private String userName;


}
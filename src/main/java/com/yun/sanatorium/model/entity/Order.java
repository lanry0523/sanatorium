package com.yun.sanatorium.model.entity;

import javax.persistence.*;

public class Order {
    /**
     * UUID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * 获取UUID
     *
     * @return id - UUID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置UUID
     *
     * @param id UUID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取门店名称
     *
     * @return store_name - 门店名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置门店名称
     *
     * @param storeName 门店名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * 获取预约项目
     *
     * @return appointment_project - 预约项目
     */
    public String getAppointmentProject() {
        return appointmentProject;
    }

    /**
     * 设置预约项目
     *
     * @param appointmentProject 预约项目
     */
    public void setAppointmentProject(String appointmentProject) {
        this.appointmentProject = appointmentProject;
    }

    /**
     * 获取订单金额
     *
     * @return amount - 订单金额
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置订单金额
     *
     * @param amount 订单金额
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 获取折扣
     *
     * @return discount - 折扣
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * 设置折扣
     *
     * @param discount 折扣
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * 获取优惠券抵用
     *
     * @return coupon_credit - 优惠券抵用
     */
    public String getCouponCredit() {
        return couponCredit;
    }

    /**
     * 设置优惠券抵用
     *
     * @param couponCredit 优惠券抵用
     */
    public void setCouponCredit(String couponCredit) {
        this.couponCredit = couponCredit;
    }

    /**
     * 获取实付金额
     *
     * @return pay_amount - 实付金额
     */
    public String getPayAmount() {
        return payAmount;
    }

    /**
     * 设置实付金额
     *
     * @param payAmount 实付金额
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取到店时间
     *
     * @return arrival_time - 到店时间
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * 设置到店时间
     *
     * @param arrivalTime 到店时间
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * 获取项目时长
     *
     * @return project_time - 项目时长
     */
    public String getProjectTime() {
        return projectTime;
    }

    /**
     * 设置项目时长
     *
     * @param projectTime 项目时长
     */
    public void setProjectTime(String projectTime) {
        this.projectTime = projectTime;
    }

    /**
     * 获取下单时间，创建时间
     *
     * @return create_time - 下单时间，创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置下单时间，创建时间
     *
     * @param createTime 下单时间，创建时间
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

    /**
     * 获取支付方式
     *
     * @return payment_type - 支付方式
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 设置支付方式
     *
     * @param paymentType 支付方式
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取服务人员
     *
     * @return personal_id - 服务人员
     */
    public String getPersonalId() {
        return personalId;
    }

    /**
     * 设置服务人员
     *
     * @param personalId 服务人员
     */
    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    /**
     * 获取订单状态
     *
     * @return state - 订单状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置订单状态
     *
     * @param state 订单状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
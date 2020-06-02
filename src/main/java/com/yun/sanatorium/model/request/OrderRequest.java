package com.yun.sanatorium.model.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class OrderRequest extends BaseRequest{
    /**
     * UUID
     */
    private String id;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 预约项目
     */
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
    private String couponCredit;

    /**
     * 实付金额
     */
    private String payAmount;

    /**
     * 到店时间
     */
    private String arrivalTime;

    /**
     * 项目时长
     */
    private String projectTime;

    /**
     * 下单时间，创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 支付方式
     */
    private String paymentType;

    /**
     * 服务人员
     */
    private String personalId;

    /**
     * 订单状态
     */
    private String state;

    private String userName;

    private String startTime;

    private String endTime;
}

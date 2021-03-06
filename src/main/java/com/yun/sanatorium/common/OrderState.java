package com.yun.sanatorium.common;

/**
 * 订单支付状态
 */
public enum OrderState {
    UNPAID("P00","未支付"),
    IN_PAYMENT("P01","支付中"),
    PAID("P02","已支付"),
    COMPLETED("P03","已完成"),
    CANCELLED("P04","已取消"),
    PAY_AT_THE_STORE("P05","到店支付");
    private String code;
    private String message;

    OrderState(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}

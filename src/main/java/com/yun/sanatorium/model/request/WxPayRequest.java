package com.yun.sanatorium.model.request;

import lombok.Data;

import java.io.Serializable;
@Data
public class WxPayRequest implements Serializable {
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String body;
    private String out_trade_no;
    private String total_fee;
    private String spbill_create_ip;
    private String notify_url;
    private String trade_type;
    private String openid;
    private String payType;//支付类型
    private String userId;
}

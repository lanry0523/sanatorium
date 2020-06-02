package com.yun.sanatorium.utils;

/**
 * @Description:
 * @Date: 2018/7/17
 * @Author: wcf
 */
public class WxPayConfig {
    //小程序appid
    public static final String appid = Constant.APP_ID;
    //微信支付的商户id
    public static final String mch_id = "";
    //微信支付的商户密钥
    public static final String key = "";
    //充值成功后的服务器回调url
    public static final String recharge_notify_url = "http://39.100.70.223:8080/pay/rechargeNotify";
    //支付成功后的服务器回调url
    public static final String notify_url = "http://39.100.70.223:8080/pay/wxNotify";
    //签名方式
    public static final String SIGNTYPE = "MD5";
    //交易类型
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}

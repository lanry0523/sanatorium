package com.yun.sanatorium.model.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 会员表request
 */
@Data
public class AppletUserRequest extends BaseRequest implements Serializable {
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 身份证
     */

    private String idNo;

    /**
     * 余额
     */
    private String balance;

    /**
     * 积分
     */
    private Integer points;

    /**
     * 公众号的普通用户的一个唯一的标识，只针对当前的公众号有效
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 公众号的全局唯一接口调用凭据
     */
    @Column(name = "access_token")
    private String accessToken;

    /**
     * 用于刷新Access Token 的 Refresh Token
     */
    private String refreshToken;

    /**
     * 头像
     */
    private String headimgurl;

    /**
     * 用户状态
     */
    private Integer status;


}
package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "applet_user")
public class AppletUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "id_no")
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
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 头像
     */
    private String headimgurl;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取身份证
     *
     * @return id_no - 身份证
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置身份证
     *
     * @param idNo 身份证
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 获取积分
     *
     * @return points - 积分
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置积分
     *
     * @param points 积分
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取公众号的普通用户的一个唯一的标识，只针对当前的公众号有效
     *
     * @return open_id - 公众号的普通用户的一个唯一的标识，只针对当前的公众号有效
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置公众号的普通用户的一个唯一的标识，只针对当前的公众号有效
     *
     * @param openId 公众号的普通用户的一个唯一的标识，只针对当前的公众号有效
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取公众号的全局唯一接口调用凭据
     *
     * @return access_token - 公众号的全局唯一接口调用凭据
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置公众号的全局唯一接口调用凭据
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取用于刷新Access Token 的 Refresh Token
     *
     * @return refresh_token - 用于刷新Access Token 的 Refresh Token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * 设置用于刷新Access Token 的 Refresh Token
     *
     * @param refreshToken 用于刷新Access Token 的 Refresh Token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * 获取头像
     *
     * @return headimgurl - 头像
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置头像
     *
     * @param headimgurl 头像
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * 获取用户状态
     *
     * @return status - 用户状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态
     *
     * @param status 用户状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
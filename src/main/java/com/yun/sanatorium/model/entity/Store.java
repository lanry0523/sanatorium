package com.yun.sanatorium.model.entity;

import javax.persistence.*;

public class Store {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 门店名称
     */
    private String name;

    /**
     * 客服电话
     */
    private String telephone;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 门店状态
     */
    private String status;

    /**
     * 门店简介
     */
    @Column(name = "store_profile")
    private String storeProfile;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取门店名称
     *
     * @return name - 门店名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置门店名称
     *
     * @param name 门店名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取客服电话
     *
     * @return telephone - 客服电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置客服电话
     *
     * @param telephone 客服电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取公司地址
     *
     * @return address - 公司地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置公司地址
     *
     * @param address 公司地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取门店状态
     *
     * @return status - 门店状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置门店状态
     *
     * @param status 门店状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取门店简介
     *
     * @return store_profile - 门店简介
     */
    public String getStoreProfile() {
        return storeProfile;
    }

    /**
     * 设置门店简介
     *
     * @param storeProfile 门店简介
     */
    public void setStoreProfile(String storeProfile) {
        this.storeProfile = storeProfile;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
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
}
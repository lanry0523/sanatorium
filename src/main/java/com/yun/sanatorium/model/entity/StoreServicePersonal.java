package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "store_service_personal")
public class StoreServicePersonal {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 门店id
     */
    @Column(name = "store_id")
    private String storeId;

    /**
     * 门店名称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 服务人员id
     */
    @Column(name = "service_personal_id")
    private String servicePersonalId;

    /**
     * 服务人员名称
     */
    @Column(name = "service_personal_name")
    private String servicePersonalName;

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
     * 获取门店id
     *
     * @return store_id - 门店id
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * 设置门店id
     *
     * @param storeId 门店id
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
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
     * 获取服务人员id
     *
     * @return service_personal_id - 服务人员id
     */
    public String getServicePersonalId() {
        return servicePersonalId;
    }

    /**
     * 设置服务人员id
     *
     * @param servicePersonalId 服务人员id
     */
    public void setServicePersonalId(String servicePersonalId) {
        this.servicePersonalId = servicePersonalId;
    }

    /**
     * 获取服务人员名称
     *
     * @return service_personal_name - 服务人员名称
     */
    public String getServicePersonalName() {
        return servicePersonalName;
    }

    /**
     * 设置服务人员名称
     *
     * @param servicePersonalName 服务人员名称
     */
    public void setServicePersonalName(String servicePersonalName) {
        this.servicePersonalName = servicePersonalName;
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
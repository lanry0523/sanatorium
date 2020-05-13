package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "store_service_item")
public class StoreServiceItem {
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
     * 服务项目id
     */
    @Column(name = "service_item_id")
    private String serviceItemId;

    /**
     * 服务项目名称
     */
    @Column(name = "service_item_name")
    private String serviceItemName;

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
     * 获取服务项目id
     *
     * @return service_item_id - 服务项目id
     */
    public String getServiceItemId() {
        return serviceItemId;
    }

    /**
     * 设置服务项目id
     *
     * @param serviceItemId 服务项目id
     */
    public void setServiceItemId(String serviceItemId) {
        this.serviceItemId = serviceItemId;
    }

    /**
     * 获取服务项目名称
     *
     * @return service_item_name - 服务项目名称
     */
    public String getServiceItemName() {
        return serviceItemName;
    }

    /**
     * 设置服务项目名称
     *
     * @param serviceItemName 服务项目名称
     */
    public void setServiceItemName(String serviceItemName) {
        this.serviceItemName = serviceItemName;
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
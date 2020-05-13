package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "store_service_category_subclass")
public class StoreServiceCategorySubclass {
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
     * 服务类别id
     */
    @Column(name = "service_category_id")
    private String serviceCategoryId;

    /**
     * 服务类别名称
     */
    @Column(name = "service_category_name")
    private String serviceCategoryName;

    /**
     * 服务类别子类id
     */
    @Column(name = "service_category_subclass_id")
    private String serviceCategorySubclassId;

    /**
     * 服务类别子类名称
     */
    @Column(name = "service_category_subclass_name")
    private String serviceCategorySubclassName;

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
     * 获取服务类别id
     *
     * @return service_category_id - 服务类别id
     */
    public String getServiceCategoryId() {
        return serviceCategoryId;
    }

    /**
     * 设置服务类别id
     *
     * @param serviceCategoryId 服务类别id
     */
    public void setServiceCategoryId(String serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    /**
     * 获取服务类别名称
     *
     * @return service_category_name - 服务类别名称
     */
    public String getServiceCategoryName() {
        return serviceCategoryName;
    }

    /**
     * 设置服务类别名称
     *
     * @param serviceCategoryName 服务类别名称
     */
    public void setServiceCategoryName(String serviceCategoryName) {
        this.serviceCategoryName = serviceCategoryName;
    }

    /**
     * 获取服务类别子类id
     *
     * @return service_category_subclass_id - 服务类别子类id
     */
    public String getServiceCategorySubclassId() {
        return serviceCategorySubclassId;
    }

    /**
     * 设置服务类别子类id
     *
     * @param serviceCategorySubclassId 服务类别子类id
     */
    public void setServiceCategorySubclassId(String serviceCategorySubclassId) {
        this.serviceCategorySubclassId = serviceCategorySubclassId;
    }

    /**
     * 获取服务类别子类名称
     *
     * @return service_category_subclass_name - 服务类别子类名称
     */
    public String getServiceCategorySubclassName() {
        return serviceCategorySubclassName;
    }

    /**
     * 设置服务类别子类名称
     *
     * @param serviceCategorySubclassName 服务类别子类名称
     */
    public void setServiceCategorySubclassName(String serviceCategorySubclassName) {
        this.serviceCategorySubclassName = serviceCategorySubclassName;
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
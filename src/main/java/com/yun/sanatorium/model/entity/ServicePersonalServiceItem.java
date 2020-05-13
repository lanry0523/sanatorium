package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "service_personal_service_item")
public class ServicePersonalServiceItem {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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
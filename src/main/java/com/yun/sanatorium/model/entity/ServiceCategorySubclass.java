package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "service_category_subclass")
public class ServiceCategorySubclass {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 项目分类名称
     */
    private String name;

    /**
     * 父类id
     */
    @Column(name = "service_category_id")
    private String serviceCategoryId;

    /**
     * 父类名称
     */
    @Column(name = "service_category_name")
    private String serviceCategoryName;

    /**
     * 排序
     */
    private Integer sort;

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
     * 获取项目分类名称
     *
     * @return name - 项目分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置项目分类名称
     *
     * @param name 项目分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父类id
     *
     * @return service_category_id - 父类id
     */
    public String getServiceCategoryId() {
        return serviceCategoryId;
    }

    /**
     * 设置父类id
     *
     * @param serviceCategoryId 父类id
     */
    public void setServiceCategoryId(String serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    /**
     * 获取父类名称
     *
     * @return service_category_name - 父类名称
     */
    public String getServiceCategoryName() {
        return serviceCategoryName;
    }

    /**
     * 设置父类名称
     *
     * @param serviceCategoryName 父类名称
     */
    public void setServiceCategoryName(String serviceCategoryName) {
        this.serviceCategoryName = serviceCategoryName;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
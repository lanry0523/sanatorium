package com.yun.sanatorium.model.entity;

import javax.persistence.*;

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 技师id
     */
    @Column(name = "personal_id")
    private String personalId;

    /**
     * 技师名称
     */
    @Column(name = "personal_name")
    private String personalName;

    /**
     * 服务项目id
     */
    @Column(name = "service_id")
    private String serviceId;

    /**
     * 服务项目名称
     */
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 分数
     */
    private String fraction;

    /**
     * 项目
     */
    private String project;

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
     * 内容
     */
    private String content;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取技师id
     *
     * @return personal_id - 技师id
     */
    public String getPersonalId() {
        return personalId;
    }

    /**
     * 设置技师id
     *
     * @param personalId 技师id
     */
    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    /**
     * 获取技师名称
     *
     * @return personal_name - 技师名称
     */
    public String getPersonalName() {
        return personalName;
    }

    /**
     * 设置技师名称
     *
     * @param personalName 技师名称
     */
    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    /**
     * 获取服务项目id
     *
     * @return service_id - 服务项目id
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 设置服务项目id
     *
     * @param serviceId 服务项目id
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * 获取服务项目名称
     *
     * @return service_name - 服务项目名称
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 设置服务项目名称
     *
     * @param serviceName 服务项目名称
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * 获取分数
     *
     * @return fraction - 分数
     */
    public String getFraction() {
        return fraction;
    }

    /**
     * 设置分数
     *
     * @param fraction 分数
     */
    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    /**
     * 获取项目
     *
     * @return project - 项目
     */
    public String getProject() {
        return project;
    }

    /**
     * 设置项目
     *
     * @param project 项目
     */
    public void setProject(String project) {
        this.project = project;
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

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
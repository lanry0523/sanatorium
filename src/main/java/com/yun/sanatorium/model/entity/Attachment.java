package com.yun.sanatorium.model.entity;

import javax.persistence.*;

public class Attachment {
    /**
     * UUID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 关联id
     */
    @Column(name = "relation_id")
    private String relationId;

    /**
     * url
     */
    private String url;

    /**
     * 附件类型
     */
    private Integer type;

    /**
     * 附件名称
     */
    private String name;

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
     * 获取UUID
     *
     * @return id - UUID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置UUID
     *
     * @param id UUID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取关联id
     *
     * @return relation_id - 关联id
     */
    public String getRelationId() {
        return relationId;
    }

    /**
     * 设置关联id
     *
     * @param relationId 关联id
     */
    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    /**
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取附件类型
     *
     * @return type - 附件类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置附件类型
     *
     * @param type 附件类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取附件名称
     *
     * @return name - 附件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置附件名称
     *
     * @param name 附件名称
     */
    public void setName(String name) {
        this.name = name;
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
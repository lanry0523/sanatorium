package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @title:Attachment
 * @description:附件表
 * @author:prince
 * @date:2020/5/14 11:21
 */
@Data
@Table(name = "attachment")
public class Attachment {

    /**
     * UUID
     */
    @Id
    private String id;

    /**
     * 关联id
     */
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
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
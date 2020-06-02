package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 服务人员表
 */
@Table(name = "service_personal")
@Data
public class ServicePersonal {
    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 擅长技术
     */
    private String skill;

    /**
     * 职称
     */
    private String title;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

}
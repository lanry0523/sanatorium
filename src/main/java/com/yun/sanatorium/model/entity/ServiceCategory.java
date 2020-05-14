package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @title:ServiceCategory
 * @description:服务类别顶级分类表
 * @author:prince
 * @date:2020/5/14 11:21
 */
@Data
@Table(name = "service_category")
public class ServiceCategory implements Serializable {

    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 项目分类名称
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
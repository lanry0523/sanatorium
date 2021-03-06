package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @title:ServiceCategorySubclass
 * @description:服务类别子类表
 * @author:prince
 * @date:2020/5/14 11:21
 */
@Data
@Table(name = "service_category_subclass")
public class ServiceCategorySubclass implements Serializable {

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
     * 父类id
     */
    private String serviceCategoryId;

    /**
     * 父类名称
     */
    private String serviceCategoryName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @title:ServiceItem
 * @description:服务项目表
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@Data
@Table(name = "service_item")
public class ServiceItem implements Serializable {

    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 简介
     */
    private String synopsis;

    /**
     * 时长
     */
    private Integer duration;

    /**
     * 服务类别id
     */
    private String serviceCategoryId;

    /**
     * 服务类别名称
     */
    private String serviceCategoryName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 团购状态
     */
    private String groupBuyStatus;

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
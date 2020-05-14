package com.yun.sanatorium.model.request;

import com.yun.sanatorium.model.entity.Attachment;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @title:ServiceItemRequest
 * @description:服务项目表request请求类
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@Data
public class ServiceItemRequest implements Serializable {

    /**
     * 主键id
     */
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

    /**
     * 缩略图
     */
    private Attachment attachmentLogo;
}
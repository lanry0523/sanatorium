package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @title:StoreServiceCategory
 * @description:门店关联服务类别顶级分类表
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@Data
@Table(name = "store_service_category")
public class StoreServiceCategory {

    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 门店id
     */
    private String storeId;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 服务类别id
     */
    private String serviceCategoryId;

    /**
     * 服务类别名称
     */
    private String serviceCategoryName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
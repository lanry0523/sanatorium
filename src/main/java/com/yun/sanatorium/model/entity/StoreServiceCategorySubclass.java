package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @title:StoreServiceCategorySubclass
 * @description:门店关联服务子类表
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:01
 */
@Data
@Table(name = "store_service_category_subclass")
public class StoreServiceCategorySubclass {

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
     * 服务类别子类id
     */
    private String serviceCategorySubclassId;

    /**
     * 服务类别子类名称
     */
    private String serviceCategorySubclassName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
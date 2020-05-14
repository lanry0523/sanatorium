package com.yun.sanatorium.model.request;

import com.yun.sanatorium.model.entity.Store;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @title:ServiceCategorySubclassRequest
 * @description:服务类别子类表request请求类
 * @author:prince
 * @date:2020/5/14 11:21
 */
@Data
public class ServiceCategorySubclassRequest implements Serializable {

    /**
     * 主键id
     */
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

    /**
     * 适用门店
     */
    private List<Store> storeList;
}
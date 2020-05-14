package com.yun.sanatorium.model.request;

import com.yun.sanatorium.model.entity.Store;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @title:StoreServicePersonalRequest
 * @description:服务人员表request请求类
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@Data
public class StoreServicePersonalRequest implements Serializable {

    /**
     * 主键id
     */
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
     * 服务人员id
     */
    private String servicePersonalId;

    /**
     * 服务人员名称
     */
    private String servicePersonalName;

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
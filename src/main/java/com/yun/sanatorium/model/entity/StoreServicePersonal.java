package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @title:StoreServicePersonal
 * @description:服务人员表
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@Data
@Table(name = "store_service_personal")
public class StoreServicePersonal implements Serializable {

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
}
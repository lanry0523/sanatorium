package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @title:Store
 * @description:门店表
 * @author:prince
 * @date:2020/5/14 11:21
 */
@Data
@Table(name = "store")
public class Store implements Serializable {

    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 门店名称
     */
    private String name;

    /**
     * 客服电话
     */
    private String telephone;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 门店状态
     */
    private String status;

    /**
     * 门店简介
     */
    private String storeProfile;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
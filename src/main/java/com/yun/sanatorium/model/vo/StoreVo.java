package com.yun.sanatorium.model.vo;

import com.yun.sanatorium.model.entity.Attachment;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @title:StoreVo
 * @description:门店管理vo类
 * @author:prince
 * @date:2020/5/14 11:21
 */
@Data
public class StoreVo implements Serializable {

    /**
     * 主键id
     */
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
     * 缩略图
     */
    private Attachment attachmentLogo;

    /**
     * 简介页面相册
     */
    private List<Attachment> attachmentAlbumList;

    /**
     * 简介页面硬件设施
     */
    private List<Attachment> attachmentFacilitiesList;
}

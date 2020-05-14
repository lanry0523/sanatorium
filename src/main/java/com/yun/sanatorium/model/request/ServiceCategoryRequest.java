package com.yun.sanatorium.model.request;

import com.yun.sanatorium.model.entity.Attachment;
import com.yun.sanatorium.model.entity.Store;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @title:ServiceCategoryRequest
 * @description:服务类别顶级分类表request请求类
 * @author:prince
 * @date:2020/5/14 11:21
 */
@Data
public class ServiceCategoryRequest implements Serializable {

    /**
     * 主键id
     */
    private String id;

    /**
     * 项目分类名称
     */
    private String name;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 分类图标
     */
    private Attachment attachmentLogo;

    /**
     * 适用门店
     */
    private List<Store> storeList;
}
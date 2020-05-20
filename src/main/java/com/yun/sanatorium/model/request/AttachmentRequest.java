package com.yun.sanatorium.model.request;

import lombok.Data;

import java.io.Serializable;
@Data
public class AttachmentRequest implements Serializable {
    /**
     * UUID
     */
    private String id;

    /**
     * 关联id
     */
    private String relationId;

    /**
     * url
     */
    private String url;

    /**
     * 附件类型
     */
    private Integer type;

    /**
     * 附件名称
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
}

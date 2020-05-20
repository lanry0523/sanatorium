package com.yun.sanatorium.model.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class CommentRequest extends BaseRequest implements Serializable {
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 技师id
     */
    @Column(name = "personal_id")
    private String personalId;

    /**
     * 技师名称
     */
    @Column(name = "personal_name")
    private String personalName;

    /**
     * 服务项目id
     */
    @Column(name = "service_id")
    private String serviceId;

    /**
     * 服务项目名称
     */
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 分数
     */
    private String fraction;

    /**
     * 项目
     */
    private String project;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 内容
     */
    private String content;
    /**
     * 评论类型("1"服务评论 "2" 技师评论)
     */
    private String commentType;

}
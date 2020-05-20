package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.Attachment;
import com.yun.sanatorium.model.request.AttachmentRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @title:AttachmentService
 * @description:**表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:24
 */
public interface AttachmentService extends Service<Attachment> {

    /**
     * 根据关联id删除数据
     *
     * @param relationId
     * @return
     */
    Integer deleteByRelationId(String relationId);

    /**
     * 根据关联id编辑数据
     *
     * @param attachment
     * @param relationId
     * @return
     */
    Attachment editAttachmentByRelationId(Attachment attachment, String relationId);

    /**
     * 根据关联id和类型查询数据
     *
     * @param relationId
     * @param type
     * @return
     */
    List<Attachment> selectByRelationIdAndType(String relationId, String type);

    /**
     * 上传附件
     * @param attachmentRequest
     * @param files
     * @return
     */
    List<Attachment> uploadFast(AttachmentRequest attachmentRequest, MultipartFile[] files);

    /**  删除
     * @param attachments 文件的全部路径 如：group1/M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     * @param attachments
     * @return
     */
    Integer delete_file(List<Attachment> attachments);

    void updateFastDFS(AttachmentRequest attachmentRequest,MultipartFile[] files);
}

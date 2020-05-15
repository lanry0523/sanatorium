package com.yun.sanatorium.dao;

import com.yun.sanatorium.core.Mapper;
import com.yun.sanatorium.model.entity.Attachment;

import java.util.List;

public interface AttachmentMapper extends Mapper<Attachment> {
    /**
     * 批量保存附件
     * @param list
     */
    void batchSaveAttachmentList(List<Attachment> list);
}
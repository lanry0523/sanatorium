package com.yun.sanatorium.dao;

import com.yun.sanatorium.core.Mapper;
import com.yun.sanatorium.model.entity.Attachment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttachmentMapper extends Mapper<Attachment> {

    /**
     * 批量保存附件
     *
     * @param list
     */
    void batchSaveAttachmentList(List<Attachment> list);

    /**
     * 根据关联id编辑数据
     *
     * @param relationId
     * @return
     */
    Integer deleteByRelationId(@Param("relationId") String relationId);

    /**
     * 根据关联id和类型查询数据
     *
     * @param relationId
     * @param type
     * @return
     */
    List<Attachment> selectByRelationIdAndType(@Param("relationId") String relationId, @Param("type") String type);
}
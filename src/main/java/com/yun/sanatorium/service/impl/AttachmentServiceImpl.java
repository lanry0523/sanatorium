package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.AttachmentMapper;
import com.yun.sanatorium.model.entity.Attachment;
import com.yun.sanatorium.service.AttachmentService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:AttachmentServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttachmentServiceImpl extends AbstractService<Attachment> implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;

}

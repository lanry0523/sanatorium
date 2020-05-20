package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.CommentMapper;
import com.yun.sanatorium.model.entity.Comment;
import com.yun.sanatorium.model.request.CommentRequest;
import com.yun.sanatorium.service.CommentService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:CommentServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:40
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> listByCondition(CommentRequest commentRequest) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentRequest, comment);
        List<Comment> comments = commentMapper.select(comment);
        return comments;
    }
}

package com.yun.sanatorium.service;

import com.yun.sanatorium.model.entity.Comment;
import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.request.CommentRequest;

import java.util.List;

/**
 * @title:CommentService
 * @description:**表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:40
 */
public interface CommentService extends Service<Comment> {

    List<Comment> listByCondition(CommentRequest commentRequest);
}

package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.GroupOrderMapper;
import com.yun.sanatorium.model.entity.GroupOrder;
import com.yun.sanatorium.service.GroupOrderService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:GroupOrderServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:40
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupOrderServiceImpl extends AbstractService<GroupOrder> implements GroupOrderService {

    @Resource
    private GroupOrderMapper groupOrderMapper;

}

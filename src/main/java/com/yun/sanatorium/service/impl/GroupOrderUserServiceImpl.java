package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.GroupOrderUserMapper;
import com.yun.sanatorium.model.entity.GroupOrderUser;
import com.yun.sanatorium.service.GroupOrderUserService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:GroupOrderUserServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupOrderUserServiceImpl extends AbstractService<GroupOrderUser> implements GroupOrderUserService {

    @Resource
    private GroupOrderUserMapper groupOrderUserMapper;

}

package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.OrderUserMapper;
import com.yun.sanatorium.model.entity.OrderUser;
import com.yun.sanatorium.service.OrderUserService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:OrderUserServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:54:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderUserServiceImpl extends AbstractService<OrderUser> implements OrderUserService {

    @Resource
    private OrderUserMapper orderUserMapper;

}

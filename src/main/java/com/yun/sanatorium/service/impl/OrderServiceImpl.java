package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.OrderMapper;
import com.yun.sanatorium.model.entity.Order;
import com.yun.sanatorium.service.OrderService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:OrderServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:54:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends AbstractService<Order> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

}

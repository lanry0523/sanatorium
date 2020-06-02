package com.yun.sanatorium.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.sanatorium.dao.OrderMapper;
import com.yun.sanatorium.model.entity.Order;
import com.yun.sanatorium.model.request.OrderRequest;
import com.yun.sanatorium.service.OrderService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Order getOne(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Order> getPage(OrderRequest orderRequest) {
        PageHelper.startPage(orderRequest.getPageNo(),orderRequest.getPageSize());
        List<Order> list = orderMapper.getPage(orderRequest);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int insert(OrderRequest orderRequest) {
        Order order = new Order();
        BeanUtils.copyProperties(orderRequest,order);
        return orderMapper.insert(order);
    }
}

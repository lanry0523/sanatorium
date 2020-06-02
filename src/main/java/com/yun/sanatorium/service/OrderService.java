package com.yun.sanatorium.service;

import com.github.pagehelper.PageInfo;
import com.yun.sanatorium.model.entity.Order;
import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.request.OrderRequest;
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.util.List;

/**
 * @title:OrderService
 * @description:**表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:54:18
 */
public interface OrderService extends Service<Order> {
    Order getOne(String id);
    PageInfo<Order> getPage(OrderRequest orderRequest);
    int insert(OrderRequest orderRequest);
}

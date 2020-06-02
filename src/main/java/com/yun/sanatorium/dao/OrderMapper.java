package com.yun.sanatorium.dao;

import com.yun.sanatorium.core.Mapper;
import com.yun.sanatorium.model.entity.Order;
import com.yun.sanatorium.model.request.OrderRequest;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    List<Order> getPage(OrderRequest order);
}
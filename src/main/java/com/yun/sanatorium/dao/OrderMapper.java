package com.yun.sanatorium.dao;

import com.yun.sanatorium.core.Mapper;
import com.yun.sanatorium.model.entity.Order;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    List<Order> getPage(Order order);
}
package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Order;
import com.yun.sanatorium.model.entity.OrderUser;
import com.yun.sanatorium.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.sanatorium.service.OrderUserService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.LoginUserUtils;
import com.yun.sanatorium.utils.Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @title:OrderController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:54:18
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private OrderUserService orderUserService;
    @PostMapping("/add")
    public Result add(@RequestBody Order order, HttpServletRequest request) {
        order.setId(Util.getUUID());
        order.setCreateTime(DateUtils.getCurrentTime());
        order.setUpdateTime(DateUtils.getCurrentTime());
        int i = orderService.save(order);
        if(i > 0){
            //用户关联订单表添加
            OrderUser orderUser = new OrderUser();
            orderUser.setId(Util.getUUID());
            orderUser.setOrderId(order.getId());
            orderUser.setCreateTime(DateUtils.getCurrentTime());
            orderUser.setUpdateTime(DateUtils.getCurrentTime());
            orderUserService.save(orderUser);
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        orderService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Order order) {
        orderService.update(order);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Order order = orderService.findById(id);
        return ResultGenerator.genSuccessResult(order);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Order> list = orderService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

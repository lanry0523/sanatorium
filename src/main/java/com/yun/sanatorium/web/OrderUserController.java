package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.OrderUser;
import com.yun.sanatorium.service.OrderUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:OrderUserController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:54:34
 */
@RestController
@RequestMapping("/orderUser")
public class OrderUserController {

    @Resource
    private OrderUserService orderUserService;

    @PostMapping("/add")
    public Result add(@RequestBody OrderUser orderUser) {
        orderUserService.save(orderUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        orderUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(OrderUser orderUser) {
        orderUserService.update(orderUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        OrderUser orderUser = orderUserService.findById(id);
        return ResultGenerator.genSuccessResult(orderUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OrderUser> list = orderUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

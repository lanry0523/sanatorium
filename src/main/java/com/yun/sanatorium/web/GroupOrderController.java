package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.GroupOrder;
import com.yun.sanatorium.service.GroupOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:GroupOrderController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:40
 */
@RestController
@RequestMapping("/groupOrder")
public class GroupOrderController {

    @Resource
    private GroupOrderService groupOrderService;

    @PostMapping("/add")
    public Result add(@RequestBody GroupOrder groupOrder) {
        groupOrderService.save(groupOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        groupOrderService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(GroupOrder groupOrder) {
        groupOrderService.update(groupOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        GroupOrder groupOrder = groupOrderService.findById(id);
        return ResultGenerator.genSuccessResult(groupOrder);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GroupOrder> list = groupOrderService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

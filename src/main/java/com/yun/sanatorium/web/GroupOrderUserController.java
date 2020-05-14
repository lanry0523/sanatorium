package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.GroupOrderUser;
import com.yun.sanatorium.service.GroupOrderUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:GroupOrderUserController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:56
 */
@RestController
@RequestMapping("/groupOrderUser")
public class GroupOrderUserController {

    @Resource
    private GroupOrderUserService groupOrderUserService;

    @PostMapping("/add")
    public Result add(@RequestBody GroupOrderUser groupOrderUser) {
        groupOrderUserService.save(groupOrderUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        groupOrderUserService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(GroupOrderUser groupOrderUser) {
        groupOrderUserService.update(groupOrderUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        GroupOrderUser groupOrderUser = groupOrderUserService.findById(id);
        return ResultGenerator.genSuccessResult(groupOrderUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GroupOrderUser> list = groupOrderUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

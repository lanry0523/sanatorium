package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.PcUser;
import com.yun.sanatorium.service.PcUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:PcUserController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:55:03
 */
@RestController
@RequestMapping("/pcUser")
public class PcUserController {

    @Resource
    private PcUserService pcUserService;

    @PostMapping("/add")
    public Result add(@RequestBody PcUser pcUser) {
        pcUserService.save(pcUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        pcUserService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PcUser pcUser) {
        pcUserService.update(pcUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody PcUser request) {
        PcUser pcUser = pcUserService.findById(request.getId());
        return ResultGenerator.genSuccessResult(pcUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PcUser> list = pcUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

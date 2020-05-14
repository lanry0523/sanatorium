package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.RechargeLog;
import com.yun.sanatorium.service.RechargeLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:RechargeLogController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:55:47
 */
@RestController
@RequestMapping("/rechargeLog")
public class RechargeLogController {

    @Resource
    private RechargeLogService rechargeLogService;

    @PostMapping("/add")
    public Result add(@RequestBody RechargeLog rechargeLog) {
        rechargeLogService.save(rechargeLog);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        rechargeLogService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(RechargeLog rechargeLog) {
        rechargeLogService.update(rechargeLog);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        RechargeLog rechargeLog = rechargeLogService.findById(id);
        return ResultGenerator.genSuccessResult(rechargeLog);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RechargeLog> list = rechargeLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

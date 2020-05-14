package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.AppointmentTime;
import com.yun.sanatorium.service.AppointmentTimeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:AppointmentTimeController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:06
 */
@RestController
@RequestMapping("/appointmentTime")
public class AppointmentTimeController {

    @Resource
    private AppointmentTimeService appointmentTimeService;

    @PostMapping("/add")
    public Result add(@RequestBody AppointmentTime appointmentTime) {
        appointmentTimeService.save(appointmentTime);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        appointmentTimeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(AppointmentTime appointmentTime) {
        appointmentTimeService.update(appointmentTime);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        AppointmentTime appointmentTime = appointmentTimeService.findById(id);
        return ResultGenerator.genSuccessResult(appointmentTime);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<AppointmentTime> list = appointmentTimeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

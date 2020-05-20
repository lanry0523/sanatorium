package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Appointment;
import com.yun.sanatorium.model.entity.AppointmentTime;
import com.yun.sanatorium.model.request.AppointmentRequest;
import com.yun.sanatorium.service.AppointmentService;
import com.yun.sanatorium.service.AppointmentTimeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public Result add(@RequestBody AppointmentTime appointmentTime) {
        appointmentTimeService.save(appointmentTime);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        appointmentTimeService.deleteByPrimaryKey(id);
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

    /**
     * 上班时间管理列表页面查询
     *
     * @return
     */
    @PostMapping("/appointmentList")
    public Result appointmentList() {
        List<Appointment> list = appointmentService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 上班时间管理列表页面查询
     *
     * @return
     */
    @PostMapping("/appointmentListDetail")
    public Result appointmentListDetail(@RequestBody Appointment appointment) {
        List<AppointmentTime> list = appointmentTimeService.findByAtId(appointment.getId());
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 上班时间管理列表页面添加
     *
     * @return
     */
    @PostMapping("/appointmentInsert")
    public Result appointmentInsert(@RequestBody AppointmentRequest request) {
        Integer insert = appointmentService.appointmentInsert(request);
        if (insert < 0) {
            return ResultGenerator.genFailResult("添加失败");
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 上班时间管理列表页面添加
     *
     * @return
     */
    @PostMapping("/appointmentUpdate")
    public Result appointmentUpdate(@RequestBody AppointmentRequest request) {
        if (StringUtils.isBlank(request.getId())) {
            return ResultGenerator.genFailResult("id不能为空");
        }
        Integer insert = appointmentService.appointmentUpdate(request);
        if (insert < 0) {
            return ResultGenerator.genFailResult("添加失败");
        }
        return ResultGenerator.genSuccessResult();
    }
}

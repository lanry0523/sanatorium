package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Appointment;
import com.yun.sanatorium.model.entity.AppointmentTime;
import com.yun.sanatorium.model.request.AppointmentRequest;
import com.yun.sanatorium.service.AppointmentService;
import com.yun.sanatorium.service.AppointmentTimeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:AppointmentTimeController
 * @description:预约时间表controller层接口
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
     * 上班时间管理详情页面查询
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
     * 上班时间管理列表页面修改
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
    /**
     * 上班时间管理列表页面删除
     *
     * @return
     */
    @PostMapping("/appointmentDelete")
    public Result appointmentDelete(@RequestBody AppointmentRequest request) {
        if (StringUtils.isBlank(request.getId())) {
            return ResultGenerator.genFailResult("id不能为空");
        }
        Integer delete = appointmentService.appointmentDelete(request.getId());
        if (delete < 0) {
            return ResultGenerator.genFailResult("删除失败");
        }
        return ResultGenerator.genSuccessResult();
    }
}

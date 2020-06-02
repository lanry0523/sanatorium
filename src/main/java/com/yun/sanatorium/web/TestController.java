package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Appointment;
import com.yun.sanatorium.model.entity.Order;
import com.yun.sanatorium.model.request.AppointmentRequest;
import com.yun.sanatorium.service.AppointmentService;
import com.yun.sanatorium.service.OrderService;
import com.yun.sanatorium.utils.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

/**
 * @author ：gaoxiao
 * @date ：Created in 2020/5/14 0014
 * @description ：
 * @version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/order")
    public Result appointmentInsert(@RequestBody AppointmentRequest request) {

        return ResultGenerator.genSuccessResult();
    }
}

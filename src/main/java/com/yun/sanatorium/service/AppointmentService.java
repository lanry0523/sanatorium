package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.Appointment;
import com.yun.sanatorium.model.entity.AppointmentTime;
import com.yun.sanatorium.model.request.AppointmentRequest;

/**
 * @title:AppointmentTimeService
 * @description:**表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:06
 */
public interface AppointmentService extends Service<Appointment> {
    Integer appointmentInsert(AppointmentRequest request);

    Integer appointmentUpdate(AppointmentRequest request);

    Integer appointmentDelete(String id);
}

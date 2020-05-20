package com.yun.sanatorium.service;

import com.yun.sanatorium.model.entity.AppointmentTime;
import com.yun.sanatorium.core.Service;

import java.util.List;

/**
 * @title:AppointmentTimeService
 * @description:**表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:06
 */
public interface AppointmentTimeService extends Service<AppointmentTime> {
    Integer batchInsert(List<AppointmentTime> appointmentTimes);

    int deleteByAtId(String atId);

    List<AppointmentTime> findByAtId(String id);
}

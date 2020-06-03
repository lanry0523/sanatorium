package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.AppointmentMapper;
import com.yun.sanatorium.dao.AppointmentTimeMapper;
import com.yun.sanatorium.model.entity.Appointment;
import com.yun.sanatorium.model.entity.AppointmentTime;
import com.yun.sanatorium.model.request.AppointmentRequest;
import com.yun.sanatorium.service.AppointmentService;
import com.yun.sanatorium.service.AppointmentTimeService;
import com.yun.sanatorium.utils.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:AppointmentTimeServiceImpl
 * @description: 表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AppointmentServiceImpl extends AbstractService<Appointment> implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private AppointmentTimeService appointmentTimeService;

    /**
     * 预约时间添加
     *
     * @param request
     * @return
     */
    @Override
    public Integer appointmentInsert(AppointmentRequest request) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(request, appointment);
        String uuid = Util.getUUID();
        appointment.setId(uuid);
        int insert1 = appointmentMapper.insert(appointment);
        List<AppointmentTime> appointmentTimes = request.getAppointmentTimes();
        Integer insert = 0;
        if (null != appointmentTimes && appointmentTimes.size() > 0) {
            for (AppointmentTime appointmentTime : appointmentTimes) {
                appointmentTime.setName(request.getName());
                appointmentTime.setId(Util.getUUID());
                appointmentTime.setAtId(uuid);
            }
            insert = appointmentTimeService.batchInsert(appointmentTimes);
        }
        return insert1 + insert;
    }

    /**
     * 预约时间修改
     *
     * @param request
     * @return
     */
    @Override
    public Integer appointmentUpdate(AppointmentRequest request) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(request, appointment);
        int update = appointmentMapper.updateByPrimaryKey(appointment);
        List<AppointmentTime> appointmentTimes = request.getAppointmentTimes();
        Integer insert = 0;
        appointmentTimeService.deleteByAtId(request.getId());
        if (null != appointmentTimes && appointmentTimes.size() > 0) {
            for (AppointmentTime appointmentTime : appointmentTimes) {
                appointmentTime.setName(request.getName());
                appointmentTime.setId(Util.getUUID());
                appointmentTime.setAtId(request.getId());
            }
            insert = appointmentTimeService.batchInsert(appointmentTimes);
        }
        return update + insert;
    }

    @Override
    public Integer appointmentDelete(String id) {
        int delete = appointmentMapper.deleteByPrimaryKey(id);
        int delete1 = appointmentTimeService.deleteByAtId(id);
        return delete+delete1;

    }
}

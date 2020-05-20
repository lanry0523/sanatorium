package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.AppointmentTimeMapper;
import com.yun.sanatorium.model.entity.AppointmentTime;
import com.yun.sanatorium.service.AppointmentTimeService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:AppointmentTimeServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AppointmentTimeServiceImpl extends AbstractService<AppointmentTime> implements AppointmentTimeService {

    @Resource
    private AppointmentTimeMapper appointmentTimeMapper;

    @Override
    public Integer batchInsert(List<AppointmentTime> appointmentTimes) {

        return appointmentTimeMapper.batchInsert(appointmentTimes);
    }

    @Override
    public int deleteByAtId(String atId) {
        return appointmentTimeMapper.deleteByAtId(atId);
    }

    @Override
    public List<AppointmentTime> findByAtId(String atId) {
        return appointmentTimeMapper.findByAtId(atId);
    }
}

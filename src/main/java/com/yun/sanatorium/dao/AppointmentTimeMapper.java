package com.yun.sanatorium.dao;

import com.yun.sanatorium.core.Mapper;
import com.yun.sanatorium.model.entity.AppointmentTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentTimeMapper extends Mapper<AppointmentTime> {
    Integer batchInsert(List<AppointmentTime> appointmentTimes);

    int deleteByAtId(@Param("atId") String atId);

    List<AppointmentTime> findByAtId(@Param("atId")String atId);
}
package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "appointment_time")
@Data
public class AppointmentTime {
    @Id
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 星期
     */
    private String week;

    /**
     * 最多预约人数
     */
    @Column(name = "appointments_numbers")
    private String appointmentsNumbers;
    /**
     * 预约主表id
     */
    private String atId;

}
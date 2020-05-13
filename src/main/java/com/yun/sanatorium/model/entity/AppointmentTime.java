package com.yun.sanatorium.model.entity;

import javax.persistence.*;

@Table(name = "appointment_time")
public class AppointmentTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取星期
     *
     * @return week - 星期
     */
    public String getWeek() {
        return week;
    }

    /**
     * 设置星期
     *
     * @param week 星期
     */
    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * 获取最多预约人数
     *
     * @return appointments_numbers - 最多预约人数
     */
    public String getAppointmentsNumbers() {
        return appointmentsNumbers;
    }

    /**
     * 设置最多预约人数
     *
     * @param appointmentsNumbers 最多预约人数
     */
    public void setAppointmentsNumbers(String appointmentsNumbers) {
        this.appointmentsNumbers = appointmentsNumbers;
    }
}
package com.yun.sanatorium.model.vo;

import com.yun.sanatorium.model.entity.AppointmentTime;
import lombok.Data;

import javax.persistence.Id;
import java.util.List;

/**
 * @author ：gaoxiao
 * @date ：Created in 2020/5/18 0018
 * @description ：
 * @version: 1.0
 */
@Data
public class AppointmentVo {
    @Id
    private String id;

    /**
     * 名称
     */
    private String name;
    /**
     * 提醒时间
     */
    private List<AppointmentTime> appointmentTimes;
    /**
     * 门店id
     */
    private String storeId;

}

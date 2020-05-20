package com.yun.sanatorium.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "appointment")
@Data
public class Appointment {
    @Id

    private String id;

    /**
     * 名称
     */
    private String name;
    /**
     * 门店id
     */
    private String storeId;

}
package com.yun.sanatorium.model.request;


import lombok.Data;

/**
 * @ClassName: BaseRequest
 * @Description: 基础查询参数类
 */
@Data
public class BaseRequest {

    public BaseRequest(){
        this.pageNo = 1;
        this.pageSize = 10;
    }
    /**
     * 分页参数：起始页
     */

    private Integer pageNo;

    /**
     * 分页参数：页面行数
     */
    private Integer pageSize;
}

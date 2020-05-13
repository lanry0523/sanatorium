package com.yun.sanatorium.core;

import com.alibaba.fastjson.JSON;

/**
 * @title:Result
 * @description:统一API响应结果封装
 * @author:prince
 * @date:2020/5/7 11:01
 */
public class Result<T> {

    private int code;

    private String message;

    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

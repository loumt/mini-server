package com.mini.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @Filename: ServiceResult
 * @Description:
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 20:25
 */
public class ServiceResult<T> implements Serializable {
    private static final long serialVersionUID = 3765720967319047788L;
    private Integer code;
    private String message;
    private T data;

    public ServiceResult() {
    }

    public ServiceResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

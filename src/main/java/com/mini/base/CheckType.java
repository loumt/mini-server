package com.mini.base;

/**
 * @Filename: CheckType
 * @Description: CheckType
 * @Version: 1.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 20:24
 */
public enum CheckType implements BaseCodeEnum {
    CHECKIN(0),
    CHECKOUT(1);

    private int code;

    private CheckType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
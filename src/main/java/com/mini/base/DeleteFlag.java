package com.mini.base;

/**
 * @Filename: DeleteFlag
 * @Description: DeleteFlag
 * @Version: 1.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 20:24
 */
public enum DeleteFlag implements BaseCodeEnum {
    VALID(0),
    DELETED(1);

    private int code;

    private DeleteFlag(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
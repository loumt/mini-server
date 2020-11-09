package com.mini.utils;

import com.mini.base.BaseCodeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Filename: CodeEnumTypeHandler
 * @Description: CodeEnumTypeHandler
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 19:59
 */

public class CodeEnumTypeHandler<E extends Enum<?> & BaseCodeEnum> extends BaseTypeHandler<BaseCodeEnum> {
    private Class<E> type;

    public CodeEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            this.type = type;
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseCodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return rs.wasNull() ? null : this.codeOf(code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return rs.wasNull() ? null : this.codeOf(code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return cs.wasNull() ? null : this.codeOf(code);
    }

    private E codeOf(int code) {
        try {
            return this.codeOf(this.type, code);
        } catch (Exception var3) {
            throw new IllegalArgumentException("Cannot convert " + code + " to " + this.type.getSimpleName() + " by code value.", var3);
        }
    }

    private <E extends Enum<?> & BaseCodeEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = (E[]) enumClass.getEnumConstants();
        Enum[] var4 = enumConstants;
        int var5 = enumConstants.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            E e = (E) var4[var6];
            if (((BaseCodeEnum)e).getCode() == code) {
                return e;
            }
        }

        return null;
    }
}
package com.mini.utils;

import com.mini.base.BaseCodeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Filename: AutoEnumTypeHandler
 * @Description: AutoEnumTypeHandler
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 19:59
 */

public class AutoEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
    private BaseTypeHandler typeHandler = null;

    public AutoEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            if (BaseCodeEnum.class.isAssignableFrom(type)) {
                this.typeHandler = new CodeEnumTypeHandler(type);
            } else {
                this.typeHandler = new EnumTypeHandler(type);
            }

        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        this.typeHandler.setNonNullParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return (E) this.typeHandler.getNullableResult(rs, columnName);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return (E) this.typeHandler.getNullableResult(rs, columnIndex);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return (E) this.typeHandler.getNullableResult(cs, columnIndex);
    }
}

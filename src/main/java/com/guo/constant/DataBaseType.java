package com.guo.constant;

import com.guo.IBaseEnum;

/**
 * @描述：数据库类型
 * @作者： Created by guoshuai on 2018/11/26 0026.
 */
public enum DataBaseType implements IBaseEnum {

    ORACLE(1, "ORACLE"),
    MYSQL(2, "MYSQL"),
    SQL_SERVER(3, "SQL_SERVER");

    // 编码
    private int code;

    // 描述
    private String comment;

    DataBaseType(int code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    public int getCode() {
        return code;
    }

    public String getComment() {
        return comment;
    }
}

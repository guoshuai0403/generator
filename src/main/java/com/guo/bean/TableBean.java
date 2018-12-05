package com.guo.bean;

import java.util.List;

/**
 * 表配置
 */
public class TableBean {

    private String type;

    private String name;

    private String comment;

    private DataBaseBean dataBase;

    private List<ColumnBean> columns;

    private String auth;

    private String packageName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DataBaseBean getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBaseBean dataBase) {
        this.dataBase = dataBase;
    }

    public List<ColumnBean> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnBean> columns) {
        this.columns = columns;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "TableBean{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", dataBase=" + dataBase +
                ", columns=" + columns +
                '}';
    }
}

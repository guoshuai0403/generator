package com.guo.bean;

/**
 * 列属性配置
 */
public class ColumnBean {

    public ColumnBean() {
    }

    public ColumnBean(String name){

        this.name = name;
    }

    private String type;

    private String name;

    private String comment;

    private String columnType;

    private Integer length;

    private TableBean table;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public TableBean getTable() {
        return table;
    }

    public void setTable(TableBean table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "ColumnBean{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", length=" + length +
                ", table=" + table +
                '}';
    }
}

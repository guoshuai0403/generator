package com.guo.bean;

import com.guo.constant.DataBaseType;

import java.util.List;

/**
 * 数据库配置
 */
public class DataBaseBean {

    /**
     * 数据库类型
     */
    private DataBaseType type;

    /**
     * 数据库IP
     */
    private String ip;

    /**
     * 数据库端口号
     */
    private Integer port;

    /**
     * 数据库登录名
     */
    private String username;

    /**
     * 数据库登录密码
     */
    private String password;

    /**
     * 数据库名称、服务名称
     */
    private String name;

    /**
     * 数据库中的表
     */
    private List<TableBean> tables;

    // ----get-------set-----------------------------------------------------

    public DataBaseType getType() {
        return type;
    }

    public void setType(DataBaseType type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TableBean> getTables() {
        return tables;
    }

    public void setTables(List<TableBean> tables) {
        this.tables = tables;
    }

    /**
     * 获取连接数据库驱动
     * @return
     */
    public String getDriver(){

        switch (this.getType()){
            case ORACLE:
                return "com.mysql.jdbc.Driver";
            case MYSQL:
                return "com.mysql.cj.jdbc.Driver";
            case SQL_SERVER:
                break;
        }
        return null;
    }

    /**
     * 获取连接数据库url
     * @return
     */
    public String getUrl(){

        switch (this.getType()){
            case ORACLE:
                return "jdbc:mysql://"+ this.getIp() +":"+ this.getPort() +"/" + this.getName() + "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
            case MYSQL:
                return "jdbc:mysql://"+ this.getIp() +":"+ this.getPort() +"/" + this.getName() + "?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
            case SQL_SERVER:
                break;
        }

        return null;
    }

    @Override
    public String toString() {
        return "DataBaseBean{" +
                "type=" + type +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tables=" + tables +
                '}';
    }
}

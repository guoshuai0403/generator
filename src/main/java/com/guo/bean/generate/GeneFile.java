package com.guo.bean.generate;

import java.util.List;

/**
 * 【系统生成的文件】
 *
 * @author guoshuai
 * @date 2018/12/5 0005
 * @updateBy
 * @updateDate
 */
public class GeneFile {

    /**
     * 公共路径
     */
    private String commonPath;

    /**
     * 作者
     */
    private String auth;

    /**
     * 公共包名
     */
    private String commonPackageName;

    /**
     * 数据库表名
     */
    private List<String> tableName;

    /**
     * 文件类型
     */
    private List<Integer> fileTypes;

    /**
     * 客户端ip
     */
    private String ip;

    // ------get------------------set--------------------------------------

    public String getCommonPath() {
        return commonPath;
    }

    public void setCommonPath(String commonPath) {
        this.commonPath = commonPath;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getCommonPackageName() {
        return commonPackageName;
    }

    public void setCommonPackageName(String commonPackageName) {
        this.commonPackageName = commonPackageName;
    }

    public List<String> getTableName() {
        return tableName;
    }

    public void setTableName(List<String> tableName) {
        this.tableName = tableName;
    }

    public List<Integer> getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(List<Integer> fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

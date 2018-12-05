package com.guo.bean.generate;


import com.guo.bean.TableBean;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 描述：实体类字段
 * 创建人： guoshuai
 * 创建时间： 2018-03-31 17:42
 */
public class Bean {

    // 描述
    private String description;

    // 作者
    private String auth;

    // 创建时间
    private String createTime;

    // 包名
    private String packageName;

    // 类类型class interface enum
    private String classType;

    //  类名
    private String className;

    // 命名空间
    private String namespace;

    // 实体类对应的全路径
    private String entityFullName;

    // 类对应的数据库表
    private TableBean tableBean;

    // java 字段属性
    private List<JavaAttr> attrs;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public TableBean getTableBean() {
        return tableBean;
    }

    public void setTableBean(TableBean tableBean) {
        this.tableBean = tableBean;
    }

    public List<JavaAttr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<JavaAttr> attrs) {
        this.attrs = attrs;
    }

    public String getEntityFullName() {

        if (StringUtils.isEmpty(this.entityFullName)) {

            return this.packageName;
        }

        return entityFullName;
    }

    public void setEntityFullName(String entityFullName) {

        this.entityFullName = entityFullName;
    }


}

package com.guo.bean.generate;


import com.guo.bean.ColumnBean;
import com.guo.util.StringUtil;

/**
 * 描述：数据库对应的字段属性
 * 创建人： guoshuai
 * 创建时间： 2018-04-01 10:27
 */
public class JavaAttr {

    // 属性名
    private String name;

    // 属性描述
    private String comment;

    // 属性类型
    private String type;

    // 属性名称首字母大写
    private String nameFirstToUpper;

    // 数据库字段
    private ColumnBean columnBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNameFirstToUpper() {

        if (nameFirstToUpper == null) {

            return StringUtil.firstToUpper(this.name);
        }

        return nameFirstToUpper;
    }

    public void setNameFirstToUpper(String nameFirstToUpper) {
        this.nameFirstToUpper = nameFirstToUpper;
    }

    public ColumnBean getColumnBean() {
        return columnBean;
    }

    public void setColumnBean(ColumnBean columnBean) {


        this.columnBean = columnBean;
    }
}

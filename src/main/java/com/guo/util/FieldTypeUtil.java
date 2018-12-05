package com.guo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 描述：属性、字段工具类
 * 创建人： guoshuai
 * 创建时间： 2018-03-31 18:06
 */
public class FieldTypeUtil {

    private static String dataTypeFilePath = "mybatis/datatype.properties";

    public static String jdbcToJava(String jdbcType){

        InputStream resourceAsStream = FieldTypeUtil.class.getClassLoader().getResourceAsStream(dataTypeFilePath);

        Properties pro = new Properties();
        try {
            pro.load(resourceAsStream);

            return pro.getProperty(jdbcType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

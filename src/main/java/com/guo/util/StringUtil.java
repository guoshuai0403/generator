package com.guo.util;

import org.springframework.util.StringUtils;

/**
 * 【】
 *
 * @author guoshuai
 * @date 2018/11/25 0025
 * @updateBy
 * @updateDate
 */
public class StringUtil extends StringUtils {

    /**
     * 下划线区分的名字改成驼峰命名
     * @param str
     * @return
     */
    public static String hump(String str){
        if (StringUtils.isEmpty(str)) {

            return null;
        }

        String s = str.toLowerCase();

        String[] split = s.split("_");

        StringBuffer sb = new StringBuffer();

        for (String string : split) {

            sb.append(StringUtil.firstToUpper(string));
        }

        return StringUtil.firstToLower(sb.toString());
    }

    /**
     * 首字母小写
     * @return
     */
    public static String firstToLower (String str) {

        if (StringUtils.isEmpty(str)) {

            return "";
        }

        return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
    }

    /**
     * 首字母大写
     * @return
     */
    public static String firstToUpper (String str) {

        if (StringUtils.isEmpty(str)) {

            return "";
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }
}

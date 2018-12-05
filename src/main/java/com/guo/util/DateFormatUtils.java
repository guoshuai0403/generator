package com.guo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 【】
 *
 * @author guoshuai
 * @date 2018/11/26 0026
 * @updateBy
 * @updateDate
 */
public class DateFormatUtils {

    /**
     * 获取指定格式时间
     * @return
     */
    public static String getFormatTime(String reg){
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        return sdf.format(new Date());
    }
}

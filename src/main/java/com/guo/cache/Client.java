package com.guo.cache;


import com.guo.bean.DataBaseBean;

import java.util.HashMap;
import java.util.Map;

/**
 * map 做client简单缓存工具类
 */
public class Client {

    private static Map<String, DataBaseBean> cache;

    /**
     * 根据客户端ip获取数据库配置
     * @param key
     * @return
     */
    public static DataBaseBean  getCache(String key){

        if (cache == null) {

            return null;
        }

        return cache.get(key);
    }

    /**
     * 设置客户端缓存
     * @param ip
     * @param dataBase
     */
    public static void setCache(String ip, DataBaseBean dataBase){

        if (cache == null) {

            synchronized (Client.class){

                if (cache == null) {

                    cache = new HashMap<>();
                }
            }
        }

        cache.put(ip, dataBase);
    }

}

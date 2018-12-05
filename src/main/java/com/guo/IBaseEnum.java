package com.guo;

/**
 * @描述：枚举类的基础类，所有自定义的枚举类都需要实现这个接口
 * @作者： Created by guoshuai on 2018/12/2 0002.
 */
public interface IBaseEnum {

    /**
     * 获取枚举类的编码
     * @return
     */
    int getCode();

    /**
     * 获取枚举类的说明
     * @return
     */
    String getComment();

}

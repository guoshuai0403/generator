package com.guo.util;

import com.guo.IBaseEnum;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 枚举类操作工具类
 */
public class EnumUtil {

    /**
     * 传入的参数ordinal指的是需要的枚举值在设定的枚举类中的顺序，以0开始
     * @param clazz
     * @param ordinal
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T indexOf (Class<T> clazz, int ordinal) {

        return (T) clazz.getEnumConstants()[ordinal];
    }

    /**
     * 传入的参数name指的是枚举值的名称，一般是大写加下划线的
     * @param clazz
     * @param name
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T nameOf(Class<T> clazz, String name){

        return (T) Enum.valueOf(clazz, name);
    }

    /**
     * 根据code值获取对应的枚举类型
     * @param clazz
     * @param code
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T getByCode(Class<T> clazz, int code, String declaredMethodName) {

        return EnumUtil.getByCode(clazz, String.valueOf(code), declaredMethodName);
    }

    /**
     * 根据code值获取对应的枚举类型
     * @param clazz
     * @param code
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T getByCode(Class<T> clazz, String code, String declaredMethodName) {

        if (StringUtils.isEmpty(code)) {

            return null;
        }

        T[] enumConstants = clazz.getEnumConstants();

        try {
            Method getCode = clazz.getDeclaredMethod(declaredMethodName);

            String codeVal;

            for (T entity : enumConstants) {

                codeVal = getCode.invoke(entity).toString();

                if (code.equals(codeVal)) {

                    return entity;
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据code值获取枚举常量
     * @param enumClass
     * @param code
     * @param <E>
     * @return
     */
    public static <E extends Enum<?> & IBaseEnum> E getByCode(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code)
                return e;
        }
        return null;
    }
}

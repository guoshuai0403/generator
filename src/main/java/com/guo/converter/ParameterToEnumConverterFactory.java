package com.guo.converter;

import com.guo.IBaseEnum;
import com.guo.util.EnumUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * 【将Integer转换为枚举类型】
 *
 * @author guoshuai
 * @date 2018/12/2 0002
 * @updateBy
 * @updateDate
 */
public class ParameterToEnumConverterFactory implements ConverterFactory<String, IBaseEnum> {

    @Override
    public <T extends IBaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        if (!targetType.isEnum()) {
            throw new UnsupportedOperationException("只支持转换到枚举类型");
        }
        return new IntegerToEnumConverter(targetType);
    }

    private class IntegerToEnumConverter<T extends Enum<?> & IBaseEnum> implements Converter<String, T> {
        private final Class<T> enumType;

        public IntegerToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String s) {
            return EnumUtil.getByCode(enumType, Integer.parseInt(s));
        }
    }


}

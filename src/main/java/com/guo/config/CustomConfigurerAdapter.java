package com.guo.config;

import com.guo.converter.ParameterToEnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 自定义配置
 *
 * @author guoshuai
 * @date 2018/11/26 0026
 * @updateBy
 * @updateDate
 */
@Configuration
public class CustomConfigurerAdapter extends WebMvcConfigurationSupport {

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverterFactory(new ParameterToEnumConverterFactory());
    }
}

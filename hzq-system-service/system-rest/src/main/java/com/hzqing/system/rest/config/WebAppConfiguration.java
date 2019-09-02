package com.hzqing.system.rest.config;

import com.hzqing.common.rest.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * webapp 配置
 * @author hzqing
 * @date 2019-08-28 15:01
 */
@Configuration
public class WebAppConfiguration implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration logRegistration = registry.addInterceptor(logInterceptor);
        //拦截所有的请求
        logRegistration.addPathPatterns("/**");
    }
}

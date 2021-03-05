package com.bobby.wiki.config;

import com.bobby.wiki.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig {

    @Resource
    LogInterceptor logInterceptor;

    public void addInterceptor(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}

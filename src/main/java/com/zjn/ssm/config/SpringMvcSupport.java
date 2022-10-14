package com.zjn.ssm.config;

import com.zjn.ssm.controller.interceptor.ProjectInterceptor;
import com.zjn.ssm.controller.interceptor.ProjectInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * 设置静态资源过滤
 */
@Configuration
//实现WebMvcConfigurer接口可以简化开发，但具有一定的侵入性
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Resource
    private ProjectInterceptor projectInterceptor;
    @Resource
    private ProjectInterceptor2 projectInterceptor2;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**")
            .addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**")
            .addResourceLocations("/css/");
        registry.addResourceHandler("/js/**")
            .addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**")
            .addResourceLocations("/plugins/");
    }

    // 配置加载拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books/","/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books/","/books/*");
    }
}
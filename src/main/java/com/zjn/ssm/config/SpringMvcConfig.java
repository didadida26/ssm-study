package com.zjn.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.zjn.ssm.controller","com.zjn.ssm.config"}) // com.zjn.ssm.config springmvc加载配置
@EnableWebMvc
public class SpringMvcConfig {
}
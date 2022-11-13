package com.langxi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.langxi.controller","com.langxi.config"})
@EnableWebMvc
public class SpringMvcConfig {
}

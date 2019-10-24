package com.iceland.springboot.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

@Configuration
public class DruidConfig {
    @Bean
    public FilterRegistrationBean createFR() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebStatFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;

    }
    @Bean
    public ServletRegistrationBean createSRB() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings("/druid/*");
        return registrationBean;
    }
}

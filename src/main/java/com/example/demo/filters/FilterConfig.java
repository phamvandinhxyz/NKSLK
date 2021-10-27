package com.example.demo.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<FilterCors> FilterCors(){
        FilterRegistrationBean<FilterCors> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new FilterCors());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

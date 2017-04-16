package com.yunyou.config;

import com.yunyou.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lds on 2016/12/10.
 */
@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new UserFilter());
        registration.addUrlPatterns("/activity.html","/dynamic.html","/strategy.html");
        return registration;
    }
}

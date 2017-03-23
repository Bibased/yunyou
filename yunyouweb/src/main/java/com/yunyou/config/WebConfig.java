package com.yunyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

/**
 * Created by lds on 2016/12/10.
 */
@Configuration
public class WebConfig {
//    @Bean
//    public ViewResolver viewResolver(){
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setCacheable(false);
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        TemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine);
//        return viewResolver;
//   }
}

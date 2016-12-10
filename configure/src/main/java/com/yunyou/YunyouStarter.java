package com.yunyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.yunyou")
public class YunyouStarter
{
    public static void main( String[] args )
    {
        SpringApplication.run(YunyouStarter.class,args);
    }
}

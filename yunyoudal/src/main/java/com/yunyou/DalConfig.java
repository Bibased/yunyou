package com.yunyou;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by dell on 2017/3/26.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.yunyou.dal.dao")
public class DalConfig {
}

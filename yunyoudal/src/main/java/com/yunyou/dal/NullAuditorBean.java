package com.yunyou.dal;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Created by lds on 2017/4/18.
 */
public class NullAuditorBean implements AuditorAware {

    @Override
    public Object getCurrentAuditor() {
        return null;
    }
}
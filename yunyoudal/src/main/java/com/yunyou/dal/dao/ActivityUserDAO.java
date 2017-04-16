package com.yunyou.dal.dao;

import com.yunyou.dal.entity.ActivityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by lds on 2017/4/16.
 */
@Component
public interface ActivityUserDAO extends JpaRepository<ActivityUser,Long> {
}

package com.yunyou.dal.dao;

import com.yunyou.dal.entity.DynamicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by lds on 2017/5/5.
 */
public interface DynamicUserDAO extends JpaRepository<DynamicUser,Long> {
    DynamicUser findByUserIdAndDynamicId(Long userId,Long dynamicId);
}

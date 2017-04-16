package com.yunyou.dal.dao;

import com.yunyou.dal.entity.UserUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lds on 2017/4/16.
 */
public interface UserUserDAO extends JpaRepository<UserUser,Long>{
    List<UserUser> findByFanId(Long fanId);
    @Query("select starId from UserUser where fanId=?1")
    List<Long> queryByFanId(Long fanId);
}

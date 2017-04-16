package com.yunyou.dal.dao;

import com.yunyou.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dell on 2017/3/14.
 */
public interface UserDAO extends JpaRepository<User,Long> {
    List<User> findByIdIn(List<Long> ids);
    User findByUsername(String username);
}

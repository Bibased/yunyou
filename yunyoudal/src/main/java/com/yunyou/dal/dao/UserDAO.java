package com.yunyou.dal.dao;

import com.yunyou.dal.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Created by dell on 2017/3/14.
 */
public interface UserDAO extends Repository<User,Long> {
    public User findById(Long id);
    @Query("select name from User where id=:k")
    public String findNameById(@Param("k") Long id);
}

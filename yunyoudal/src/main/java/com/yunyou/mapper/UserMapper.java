package com.yunyou.mapper;

import com.yunyou.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lds on 2016/12/18.
 */
@Mapper
public interface UserMapper {
    User findByName(@Param("name") String name);
    int insert(User user);
}
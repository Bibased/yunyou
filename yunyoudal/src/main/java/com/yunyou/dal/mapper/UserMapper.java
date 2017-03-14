package com.yunyou.dal.mapper;

import com.yunyou.dal.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lds on 2016/12/18.
 */
@Mapper
public interface UserMapper {
    User findByName(@Param("name") String name);
    int insert(User user);
}
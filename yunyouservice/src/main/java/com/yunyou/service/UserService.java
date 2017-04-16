package com.yunyou.service;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dell on 2017/4/12.
 */
@Service
public class UserService {
    @Resource
    private UserDAO userDAO;
    public boolean legalUser(User user){
        if (null == user ) return false;
        if (null == user.getUsername() || null == user.getPassword()) return false;
        User dbUser = userDAO.findByUsername(user.getUsername());
        if (null == dbUser ) return false;
        if (user.getPassword().equals(dbUser.getPassword())){
            user.setId(dbUser.getId());
            user.setPicUrl(dbUser.getPicUrl());
            return true;
        }
        return false;
    }

}

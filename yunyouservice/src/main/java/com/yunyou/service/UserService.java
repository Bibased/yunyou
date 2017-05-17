package com.yunyou.service;
import com.yunyou.dal.cache.CacheDAO;
import com.yunyou.dal.cache.co.UserCO;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.entity.User;
import org.mindrot.jbcrypt.BCrypt;
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
        if (BCrypt.checkpw(user.getPassword(),dbUser.getPassword())){
            user.setId(dbUser.getId());
            user.setPicUrl(dbUser.getPicUrl());
            return true;
        }
        return false;
    }
    public UserCO query(Long id){
//        UserCO userCO = null;
//        try {
//            userCO = CacheDAO.getUserById(id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        if (null == userCO) {
//            userCO = converToUserCO(userDAO.getOne(id));
//            CacheDAO.setUser(id,userCO);
//        }
//        return userCO;
        return converToUserCO(userDAO.getOne(id));
    }
    public  boolean save(User user){
        user = userDAO.save(user);
//        CacheDAO.setUser(user.getId(),converToUserCO(user));
        return true;
    }
    public UserCO converToUserCO(User user){
        return new UserCO(user.getUsername(),user.getPicUrl(),0);
    }
}

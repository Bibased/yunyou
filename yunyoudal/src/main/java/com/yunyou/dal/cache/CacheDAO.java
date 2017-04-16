package com.yunyou.dal.cache;


import com.yunyou.common.util.RedisManager;
import com.yunyou.dal.cache.co.UserCO;
import org.springframework.stereotype.Component;

/**
 * Created by lds on 2017/4/13.
 */
public class CacheDAO {
    public static final String USER_PREFIX="user_";
    public static UserCO getUserById(Long id){
        return RedisManager.getObj(USER_PREFIX+id,UserCO.class);
    }
    public static String setUser(Long id,UserCO userCO){
        return RedisManager.setObj(USER_PREFIX+id,userCO);
    }
}

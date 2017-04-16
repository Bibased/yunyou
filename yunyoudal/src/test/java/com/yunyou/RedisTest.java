package com.yunyou;

import com.yunyou.common.util.RedisManager;
import com.yunyou.dal.cache.CacheDAO;
import com.yunyou.dal.cache.co.UserCO;
import org.junit.Test;

/**
 * Created by lds on 2017/4/13.
 */
public class RedisTest {
    @Test
    public void test(){
        CacheDAO.setUser(1L,new UserCO("John","/static/img/user.PNG",1));
        UserCO userCO = CacheDAO.getUserById(1L);
        System.out.println(userCO.getUsername());
    }
}

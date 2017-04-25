package com.yunyou.util;

import com.yunyou.dal.entity.User;

import javax.servlet.http.HttpSession;

/**
 * Created by lds on 2017/4/17.
 */
public class SessionUtil {
    public static Long getUserId(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (null == user) return null;
        return user.getId();
    }
}

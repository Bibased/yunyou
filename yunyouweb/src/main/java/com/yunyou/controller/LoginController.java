package com.yunyou.controller;

import com.yunyou.common.AppResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by dell on 2017/3/15.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public AppResult login(String username, String password, HttpSession session){
       session.setAttribute("user",new User(username,password));
        System.out.println(((User)session.getAttribute("user")).getUsername());
        return new AppResult();
    }
}

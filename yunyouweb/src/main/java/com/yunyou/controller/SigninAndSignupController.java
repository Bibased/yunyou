package com.yunyou.controller;

import com.yunyou.common.AppResult;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.entity.User;
import com.yunyou.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by dell on 2017/3/15.
 */
@Controller
public class SigninAndSignupController {
    @Resource
    private UserService userService;
    @RequestMapping("/signin.do")
    public @ResponseBody AppResult signin(String username, String password, HttpSession session){
        User user = new User(username,password);
        if (userService.legalUser(user))
        {
            session.setAttribute("user",user);
            return new AppResult();
        }
        return new AppResult("用户名或密码错误");
    }
    @RequestMapping("signup.do")
    public @ResponseBody AppResult signup(User user,String confirmPsw){

        if (!user.getPassword().equals(confirmPsw)){
            return new AppResult("两次密码不一致");
        }

        userService.save(user);
        return new AppResult();
    }
    @RequestMapping("/signout")
    public String signout(HttpSession session){
        session.removeAttribute("user");
        return "index";
    }
}

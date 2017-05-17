package com.yunyou.controller;

import com.yunyou.common.AppResult;
import com.yunyou.dal.entity.User;
import com.yunyou.service.UserService;
import com.yunyou.util.VerificationCode;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dell on 2017/3/15.
 */
@Controller
public class SigninAndSignupController {
    @Resource
    private UserService userService;
    @Resource
    VerificationCode verificationCode;
    @RequestMapping("/signin.do")
    public @ResponseBody AppResult signin(String username, String password, String vCode, HttpSession session){
        if (!verificationCode.verify(vCode,session))
            return new AppResult("验证码错误");
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
        String hashed = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
        user.setPassword(hashed);
        userService.save(user);
        return new AppResult();
    }
    @RequestMapping("/signout.do")
    public void signout(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("user");
        response.sendRedirect("/index.html");
    }
}

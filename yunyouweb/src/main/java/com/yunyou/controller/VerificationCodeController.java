package com.yunyou.controller;

import com.yunyou.util.VerificationCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lds on 2017/5/5.
 */
@Controller
public class VerificationCodeController {
    @Resource
    VerificationCode verificationCode;
    @RequestMapping("/vCode.png")
    private void vCode(HttpSession session, HttpServletResponse response){
        verificationCode.getCode(session,response);
    }
}

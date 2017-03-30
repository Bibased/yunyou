package com.yunyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lds on 2016/12/10.
 */
@Controller
public class CombineController {
    @RequestMapping("/index.htm")
    public String index(Model model, HttpSession session, HttpServletRequest request){
        model.addAttribute("test","testmsg");
        session.setAttribute("username","hello");
        return "index";
    }
}

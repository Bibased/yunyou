package com.yunyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lds on 2016/12/10.
 */
@Controller
public class CombineController {
    @RequestMapping("/index.htm")
    public String index(Model model){
        model.addAttribute("test","testmsg");
        return "index";
    }
}

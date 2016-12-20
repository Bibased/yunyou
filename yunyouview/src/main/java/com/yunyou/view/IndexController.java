package com.yunyou.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lds on 2016/12/10.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("hello");
        return "index";
    }
}

package com.yunyou.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lds on 2016/12/10.
 */
@Controller
public class IndexController {
    @RequestMapping("/index.htm")
    public String index(Model model){
        model.addAttribute("mainContent","index.html");
        return "container";
    }
}

package com.yunyou.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lds on 2016/12/10.
 */
@RestController
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}

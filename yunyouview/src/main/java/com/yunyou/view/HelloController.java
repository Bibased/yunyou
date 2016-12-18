package com.yunyou.view;

import com.yunyou.entity.User;
import com.yunyou.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lds on 2016/12/10.
 */
@RestController
public class HelloController {
    @Resource
    private UserMapper userMapper;
    @RequestMapping("/index")
    public String index(@Param("id") int id){
        User user = new User();
        user.setName("ljl");
        user.setId(id);
        userMapper.insert(user);
        //System.out.println(userMapper.findByName("ljl"));
        return "index";
    }
}

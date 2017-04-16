package com.yunyou.controller;

import com.yunyou.dal.dao.StrategyDao;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.dao.UserUserDAO;
import com.yunyou.dal.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lds on 2017/4/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserDAO userDAO;
    @Resource
    private UserUserDAO userUserDAO;

    @RequestMapping("star/query")
    public @ResponseBody List<User> queryStars(HttpSession session){
        Long id = ((User)(session.getAttribute("user"))).getId();
        List<Long> ids = userUserDAO.queryByFanId(id);
        return userDAO.findByIdIn(ids);
    }
}

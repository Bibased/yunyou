package com.yunyou.controller;

import com.yunyou.common.AppResult;
import com.yunyou.dal.dao.StrategyDao;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.dao.UserUserDAO;
import com.yunyou.dal.entity.User;
import com.yunyou.dal.entity.UserUser;
import com.yunyou.service.UserService;
import com.yunyou.util.SessionUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UserController {
    @Resource
    private UserDAO userDAO;
    @Resource
    private UserUserDAO userUserDAO;
    @Resource
    private UserService userService;
    @RequestMapping("/user/star/query")
    public @ResponseBody List<User> queryStars(HttpSession session,Boolean addSelf){
        if (null == addSelf) addSelf = true;
        User self = (User)(session.getAttribute("user"));
        Long id = (self).getId();
        List<Long> ids = userUserDAO.queryByFanId(id);
        List<User> users = userDAO.findByIdIn(ids);
        if (addSelf){
            User newU = new User();
            BeanUtils.copyProperties(self,newU);
            newU.setUsername("me");
            users.add(0,newU);
        }
        return users;
    }
    @RequestMapping("/user/star")
    @ResponseBody
    public AppResult star(Long fanId,Long starId,Integer act){
        if (null == act || 0 == act){
            userUserDAO.cacelStar(fanId,starId);
        }
        else {
            UserUser userUser = new UserUser();
            userUser.setFanId(fanId);
            userUser.setStarId(starId);
            userUser.setFriend(true);
            userUserDAO.save(userUser);
        }
        return new AppResult();
    }
    @RequestMapping("/user.html")
    public String userPage(Model model, HttpSession session,Long id){
        if (null == id) return "index";
        User user = userDAO.findOne(id);
        if (null == user) return "index";
        Long sessionId = SessionUtil.getUserId(session);
        model.addAttribute("isSelf",id.equals(sessionId));
        model.addAttribute("user",user);
        List<Long> ids = userUserDAO.queryByFanId(id);
        List<User> stars = userDAO.findByIdIn(ids);
        model.addAttribute("stars",stars);
        boolean isFan = false;
        if (null!= userUserDAO.findOneByFanIdAndStarId(sessionId,id))
            isFan = true;
        model.addAttribute("isFan",isFan);
        return "user-center";
    }
}

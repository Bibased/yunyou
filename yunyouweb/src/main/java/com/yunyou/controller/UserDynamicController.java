package com.yunyou.controller;

import Dymanic.UserDynamicService;
import com.yunyou.common.AppResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Liujinglin on 17/3/15.
 */
@Controller
public class UserDynamicController {

    @Resource
    private UserDynamicService userDynamicService;

    @RequestMapping("/user/dynamic/publish")
    @ResponseBody
    public AppResult publishDynamic(HttpSession httpSession, String location, Long cityId, String country,
        String[] picUrls) {
        Long userId = getUserIdFromSession(httpSession);
        AppResult appResult = new AppResult();
        return appResult;
    }

    @RequestMapping("/user/dynamic/query")
    @ResponseBody
    public AppResult queryDynamic(int pageNo, int pageSize) {

        return null;
    }


    @RequestMapping("/user/dynamic/queryByIds")
    @ResponseBody
    public AppResult queryDynamicByIds(int pageNo, int pageSize, Long[] usersId) {

        return null;
    }

    @RequestMapping("/user/dynamic/like")
    @ResponseBody
    public  AppResult likeDynamic(Long dynamicId) {

        return null;
    }
    private Long getUserIdFromSession(HttpSession httpSession) {
        if (httpSession == null) {
            throw new NullPointerException("httpSession is empty");
        }
        return Long.valueOf(httpSession.getId());
    }
}

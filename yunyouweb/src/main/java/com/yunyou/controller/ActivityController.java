package com.yunyou.controller;

import com.yunyou.common.AppResult;
import com.yunyou.common.constant.GlobalConstant;
import com.yunyou.common.util.DataConvertUtil;
import com.yunyou.dal.cache.co.UserCO;
import com.yunyou.dal.dao.ActivityDao;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.entity.Activity;
import com.yunyou.dal.entity.Strategy;
import com.yunyou.service.FileService;
import com.yunyou.service.UserService;
import com.yunyou.util.SessionUtil;
import com.yunyou.vo.ActivityVO;
import com.yunyou.vo.StrategyDetail;
import com.yunyou.vo.StrategyVO;
import org.joda.time.LocalDate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lds on 2017/4/19.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
    @Resource
    FileService fileService;
    @Resource
    ActivityDao activityDao;
    @Resource
    UserDAO userDAO;
    @Resource
    UserService userService;
    @RequestMapping("query")
    @ResponseBody
    public Page query(Long[] userIds, Integer size, Integer pageId, Long cityCode, Integer expense,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime, Integer days){
        if (null == size)
            size = GlobalConstant.DYN_SIZE;
        if (null == pageId|| pageId<0) pageId = 0;
        else pageId = pageId -1;
        PageRequest pageRequest = new PageRequest(pageId,size,
                Sort.Direction.ASC,"startTime");
        if (null == expense) expense = Integer.MAX_VALUE;
        if (null == startTime) startTime = new LocalDate().toDate();
        if (null == days) days = Integer.MAX_VALUE;
        String cc ;
        Page page = null;
        if (null != cityCode) cc = "%"+cityCode+"%";
        else  cc = "%";
        if (null == userIds || userIds.length == 0){
            page = activityDao.findByExpenseLessThanEqualAndStartTimeGreaterThanEqualAndDaysLessThanEqualAndCityIdsLike(expense,startTime,days,cc,pageRequest);
        }else {
            page =  activityDao.findByExpenseLessThanEqualAndStartTimeGreaterThanEqualAndDaysLessThanEqualAndPublisherInAndCityIdsLike(expense,startTime,days,Arrays.asList(userIds),cc,pageRequest);
        }
        return convertToVoList(page,pageRequest);
    }
    public Page convertToVoList(Page<Activity> page, Pageable pageable){
        List list = page.getContent().stream().map(activity -> {
           return convertToVO(activity);
        }).collect(Collectors.toList());
        return new PageImpl(list,pageable,page.getTotalPages());
    }
    public ActivityVO convertToVO(Activity activity){
        ActivityVO activityVO = new ActivityVO();
        BeanUtils.copyProperties(activity,activityVO);
        UserCO userCO = userService.query(activity.getPublisher());
        activityVO.setPublisherName(userCO.getUsername());
        return activityVO;
    }
    @RequestMapping("publish")
    @ResponseBody
    public AppResult publish(Activity activity, MultipartFile cover, HttpSession session,
                             String[] cityCodes, String[] cityNames){
        Long userId = SessionUtil.getUserId(session);
        activity.setPublisher(userId);
        activity.setCoverUrl(fileService.dealUploadImg(cover,userId));
        activity.setEndTime(plusDays(activity.getStartTime(),activity.getDays()));
        activity.setCityIds(DataConvertUtil.fromArray(cityCodes));
        activity.setCityNames(DataConvertUtil.fromArray(cityNames));
        activityDao.save(activity);
        return new AppResult();
    }
    @RequestMapping("detail")
    @ResponseBody
    public ActivityVO fetchDetail(Long id){
        ActivityVO item = new ActivityVO();
        Activity activity = activityDao.findOne(id);
        return convertToVO(activity);
    }
    Date plusDays(Date start,int days){
        LocalDate localDate = LocalDate.fromDateFields(start);
        return localDate.plusDays(days).toDate();
    }
}

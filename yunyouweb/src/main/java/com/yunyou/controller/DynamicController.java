package com.yunyou.controller;
import com.yunyou.common.AppResult;
import com.yunyou.common.constant.GlobalConstant;
import com.yunyou.common.util.DataConvertUtil;
import com.yunyou.dal.cache.co.UserCO;
import com.yunyou.dal.dao.DynamicDao;
import com.yunyou.dal.entity.Dynamic;
import com.yunyou.vo.DynamicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dell on 2017/4/10.
 */
@Controller
@RequestMapping("dynamic")
public class DynamicController {
    @Resource
    private DynamicDao dynamicDao;
    @RequestMapping("query")
    @ResponseBody
    public Page query(Long[] userIds, Integer size, Integer pageId){
        if (null == size)
            size = GlobalConstant.DYN_SIZE;
        if (null == pageId|| pageId<0) pageId = 0;
        else pageId = pageId -1;
        PageRequest pageRequest = new PageRequest(pageId,size,
                Sort.Direction.DESC,"createTime","likeCount");
        Page<Dynamic> dynamicPage;
        if (null == userIds || userIds.length == 0) dynamicPage = dynamicDao.findAll(pageRequest);
        else dynamicPage = dynamicDao.findByPublisherIn(Arrays.asList(userIds),pageRequest);
        return convertToVO(dynamicPage,pageRequest);
    }
    @RequestMapping("publish")
    @ResponseBody
    public AppResult publish(Dynamic dynamic){
        try {
            dynamicDao.save(dynamic);
        }catch (Exception e){
            return new AppResult("发布失败");
        }
        return new AppResult();
    }

    public Page convertToVO(Page<Dynamic> dynamicPage,Pageable pageable){
        List list = dynamicPage.getContent().stream().map(dynamic -> {
            DynamicVo dynamicVo = new DynamicVo();
            BeanUtils.copyProperties(dynamic,dynamicVo);
//            UserCO userCO = CacheDAO.getUserById(dynamic.getPublisher());
            UserCO userCO = new UserCO("John","/static/img/user.PNG",1);
            dynamicVo.setPublisher(userCO.getUsername());
            dynamicVo.setUserPic(userCO.getUserPic());
            dynamicVo.setPicUrlList(DataConvertUtil.toList(dynamic.getPicUrls()));
            dynamicVo.setCommentList(DataConvertUtil.toList(dynamic.getComments()));
            dynamicVo.setPublishTime(DataConvertUtil.fromDate(dynamic.getCreateTime()));
            return dynamicVo;
        }).collect(Collectors.toList());
        return new PageImpl(list,pageable,dynamicPage.getTotalPages());
    }
}

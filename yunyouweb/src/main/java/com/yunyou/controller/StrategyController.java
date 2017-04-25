package com.yunyou.controller;

import com.yunyou.common.AppResult;
import com.yunyou.common.constant.GlobalConstant;
import com.yunyou.common.util.DataConvertUtil;
import com.yunyou.dal.cache.co.UserCO;
import com.yunyou.dal.dao.StrategyDao;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.entity.Strategy;
import com.yunyou.service.FileService;
import com.yunyou.service.UserService;
import com.yunyou.util.SessionUtil;
import com.yunyou.vo.StrategyDetail;
import com.yunyou.vo.StrategyVO;
import org.joda.time.LocalDate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
@RequestMapping("/strategy")
public class StrategyController {
    @Resource
    FileService fileService;
    @Resource
    StrategyDao strategyDao;
    @Resource
    UserDAO userDAO;
    @Resource
    UserService userService;
    @RequestMapping("query")
    @ResponseBody
    public Page query(Long[] userIds, Integer size, Integer pageId,Integer cityCode){
        if (null == size)
            size = GlobalConstant.DYN_SIZE;
        if (null == pageId|| pageId<0) pageId = 0;
        else pageId = pageId -1;
        PageRequest pageRequest = new PageRequest(pageId,size,
                Sort.Direction.DESC,"createTime","likeCount");
        String cc = "%";
        if (null != cityCode) cc = "%"+cityCode+"%";
        Page page = null;
        if (null == userIds || userIds.length == 0){
            page = strategyDao.findByCityIdsLike(cc,pageRequest);
        }else {
            page = strategyDao.findByPublisherInAndCityIdsLike(Arrays.asList(userIds),cc,pageRequest);
        }
        return convertToVo(page,pageRequest);
    }
    public Page convertToVo(Page<Strategy> page, Pageable pageable){
        List<StrategyVO> list = page.getContent().stream().map(strategy -> {
            StrategyVO strategyVO = new StrategyVO();
            BeanUtils.copyProperties(strategy,strategyVO);
            UserCO userCO = userService.query(strategy.getPublisher());
            strategyVO.setPublisherName(userCO.getUsername());
            return strategyVO;
        }).collect(Collectors.toList());
        return new PageImpl(list,pageable,page.getTotalPages());
    }
    @RequestMapping("publish")
    @ResponseBody
    public AppResult publish(Strategy strategy, MultipartFile cover, HttpSession session,
                             String[] cityCodes,String[] cityNames){
        Long userId = SessionUtil.getUserId(session);
        strategy.setPublisher(userId);
        strategy.setCoverUrl(fileService.dealUploadImg(cover,userId));
        strategy.setEndTime(plusDays(strategy.getStartTime(),strategy.getDays()));
        strategy.setCityIds(DataConvertUtil.fromArray(cityCodes));
        strategy.setCityNames(DataConvertUtil.fromArray(cityNames));
        strategyDao.save(strategy);
        return new AppResult();
    }
    @RequestMapping("detail")
    public String fetchDetail(Model model,Long id){
        StrategyDetail item = new StrategyDetail();
        Strategy strategy = strategyDao.findOne(id);
        BeanUtils.copyProperties(strategy,item);
        item.setUser(userDAO.getOne(strategy.getPublisher()).getUsername());
        item.setCities(DataConvertUtil.toList(strategy.getCityNames()));
        model.addAttribute("item",item);
        return "strategy-detail";
    }
    Date plusDays(Date start,int days){
        LocalDate localDate = LocalDate.fromDateFields(start);
        return localDate.plusDays(days).toDate();
    }
}

package com.yunyou.dal.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private Long publishId;
    private String title;
    private String content;
    // 旅游花费
    private Integer expense;
    private Integer upperPeople;
    private Integer lowerPeople;
    // 已参加人数
    private Integer nowPeople;
    // 活动天数
    private Integer activityDays;
    private Data startTime;
    private Data endTime;
    // 报名截止时间
    private Data deadline;
    private List<Long> cityIds;
    private List<String> cityName;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Data createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getExpense() {
        return expense;
    }

    public void setExpense(Integer expense) {
        this.expense = expense;
    }

    public Integer getUpperPeople() {
        return upperPeople;
    }

    public void setUpperPeople(Integer upperPeople) {
        this.upperPeople = upperPeople;
    }

    public Integer getLowerPeople() {
        return lowerPeople;
    }

    public void setLowerPeople(Integer lowerPeople) {
        this.lowerPeople = lowerPeople;
    }

    public Integer getNowPeople() {
        return nowPeople;
    }

    public void setNowPeople(Integer nowPeople) {
        this.nowPeople = nowPeople;
    }

    public Integer getActivityDays() {
        return activityDays;
    }

    public void setActivityDays(Integer activityDays) {
        this.activityDays = activityDays;
    }

    public Data getStartTime() {
        return startTime;
    }

    public void setStartTime(Data startTime) {
        this.startTime = startTime;
    }

    public Data getEndTime() {
        return endTime;
    }

    public void setEndTime(Data endTime) {
        this.endTime = endTime;
    }

    public Data getDeadline() {
        return deadline;
    }

    public void setDeadline(Data deadline) {
        this.deadline = deadline;
    }

    public List<Long> getCityIds() {
        return cityIds;
    }

    public void setCityIds(List<Long> cityIds) {
        this.cityIds = cityIds;
    }

    public List<String> getCityName() {
        return cityName;
    }

    public void setCityName(List<String> cityName) {
        this.cityName = cityName;
    }

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }
}

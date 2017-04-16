package com.yunyou.dal.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private Long publisher;
    private String title;
    private String content;
    // 旅游花费
    private Integer expense;
    private Integer maxHC;
    private Integer minHC;
    // 已参加人数
    private Integer nowHC;
    //感兴趣人数
    private Integer focusCount;
    // 活动天数
    private Integer activityDays;
    @Temporal(TemporalType.DATE)
    private Date startTime;
    @Temporal(TemporalType.DATE)
    private Date endTime;
    // 报名截止时间
    @Temporal(TemporalType.DATE)
    private Date deadline;
    private String cityIds;
    private String cityNames;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
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

    public Integer getMaxHC() {
        return maxHC;
    }

    public void setMaxHC(Integer maxHC) {
        this.maxHC = maxHC;
    }

    public Integer getMinHC() {
        return minHC;
    }

    public void setMinHC(Integer minHC) {
        this.minHC = minHC;
    }

    public Integer getNowHC() {
        return nowHC;
    }

    public void setNowHC(Integer nowHC) {
        this.nowHC = nowHC;
    }

    public Integer getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(Integer focusCount) {
        this.focusCount = focusCount;
    }

    public Integer getActivityDays() {
        return activityDays;
    }

    public void setActivityDays(Integer activityDays) {
        this.activityDays = activityDays;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getCityIds() {
        return cityIds;
    }

    public void setCityIds(String cityIds) {
        this.cityIds = cityIds;
    }

    public String getCityNames() {
        return cityNames;
    }

    public void setCityNames(String cityNames) {
        this.cityNames = cityNames;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

package com.yunyou.dal.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private Long publisher;
    private String title;
    private String content;
    private String coverUrl;
    private String summary;
    // 旅游花费
    private int expense;
    private int maxHC;
    private int minHC;
    // 已参加人数
    private int nowHC;
    //感兴趣人数
    private int focusCount;
    // 活动天数
    private int days;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getMaxHC() {
        return maxHC;
    }

    public void setMaxHC(int maxHC) {
        this.maxHC = maxHC;
    }

    public int getMinHC() {
        return minHC;
    }

    public void setMinHC(int minHC) {
        this.minHC = minHC;
    }

    public int getNowHC() {
        return nowHC;
    }

    public void setNowHC(int nowHC) {
        this.nowHC = nowHC;
    }

    public int getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(int focusCount) {
        this.focusCount = focusCount;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

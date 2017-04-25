package com.yunyou.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lds on 2017/4/24.
 */
public class ActivityVO implements Serializable{
    private static final long serialVersionUID = -6807137154774181921L;
    private Long id;
    private Long publisher;
    private String publisherName;
    private String summary;
    private String title;
    private String content;
    private String coverUrl;
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
    private Date startTime;
    private Date endTime;
    // 报名截止时间
    private Date deadline;
    private String cityIds;
    private String cityNames;
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

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
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

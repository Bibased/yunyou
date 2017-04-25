package com.yunyou.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lds on 2017/4/20.
 */
public class StrategyDetail implements Serializable {
    private static final long serialVersionUID = -737795614365145429L;
    private String content;
    private String title;
    private String user;
    private int expense;
    private Date startTime;
    private Date endTime;
    private int days;
    private int likeCount;
    private Date createTime;
    private List cities;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List getCities() {
        return cities;
    }

    public void setCities(List cities) {
        this.cities = cities;
    }
}

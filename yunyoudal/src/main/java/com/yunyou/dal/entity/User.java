package com.yunyou.dal.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lds on 2016/12/18.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{
    private static final long serialVersionUID = 7621305592543119629L;
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String username;
    private String password;
    private String picUrl;
    private String motto;
    private int gender;

    private String visitedCities;
    private String goalCities;
    private int fans;
    private int stars;
    private int dynamicNum;
    private int strategyNum;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getVisitedCities() {
        return visitedCities;
    }

    public void setVisitedCities(String visitedCities) {
        this.visitedCities = visitedCities;
    }

    public String getGoalCities() {
        return goalCities;
    }

    public void setGoalCities(String goalCities) {
        this.goalCities = goalCities;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getDynamicNum() {
        return dynamicNum;
    }

    public void setDynamicNum(Integer dynamicNum) {
        this.dynamicNum = dynamicNum;
    }

    public Integer getStrategyNum() {
        return strategyNum;
    }

    public void setStrategyNum(Integer strategyNum) {
        this.strategyNum = strategyNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}

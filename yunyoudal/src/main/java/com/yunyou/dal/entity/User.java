package com.yunyou.dal.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lds on 2016/12/18.
 */
@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 7621305592543119629L;
    @Id
    private Long id;
    private String email;
    private String username;
    private String password;
    private String picUrl;
    private String motto;
    private Integer gender;

    private String visitedCities;
    private String goalCities;
    private Integer fans;
    private Integer stars;
    private Integer dynamic_num;
    private Integer strategy_num;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedTime;

    public Long getId() {
        return id;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDynamic_num() {
        return dynamic_num;
    }

    public void setDynamic_num(Integer dynamic_num) {
        this.dynamic_num = dynamic_num;
    }

    public Integer getStrategy_num() {
        return strategy_num;
    }

    public void setStrategy_num(Integer strategy_num) {
        this.strategy_num = strategy_num;
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

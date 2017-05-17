package com.yunyou.dal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lds on 2017/5/5.
 */
@Entity
public class DynamicUser {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long dynamicId;

    public DynamicUser(Long userId, Long dynamicId) {
        this.userId = userId;
        this.dynamicId = dynamicId;
    }

    public DynamicUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }
}

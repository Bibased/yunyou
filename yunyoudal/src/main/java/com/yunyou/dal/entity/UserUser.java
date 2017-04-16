package com.yunyou.dal.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lds on 2017/4/16.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserUser implements Serializable{
    private static final long serialVersionUID = -2394859409239782287L;
    @Id
    @GeneratedValue
    private Long id;
    private Long starId;
    private Long fanId;
    private Boolean isFriend;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public Long getFanId() {
        return fanId;
    }

    public void setFanId(Long fanId) {
        this.fanId = fanId;
    }

    public Boolean getFriend() {
        return isFriend;
    }

    public void setFriend(Boolean friend) {
        isFriend = friend;
    }
}

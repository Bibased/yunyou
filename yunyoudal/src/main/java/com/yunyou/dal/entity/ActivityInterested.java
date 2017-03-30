package com.yunyou.dal.entity;

import javax.persistence.Entity;

/**
 * Created by Liujinglin on 17/3/19.
 */
@Entity
public class ActivityInterested {
    private Long activityId;
    private Long userId;
    private Integer attentionIndex;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAttentionIndex() {
        return attentionIndex;
    }

    public void setAttentionIndex(Integer attentionIndex) {
        this.attentionIndex = attentionIndex;
    }
}

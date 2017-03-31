package com.yunyou.dal.entity;

import javax.persistence.Entity;

/**
 * Created by Liujinglin on 17/3/18.
 */
@Entity
public class StrategyCollection {
    private Long userId;
    private String strategyIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStrategyIds() {
        return strategyIds;
    }

    public void setStrategyId(String strategyIds) {
        this.strategyIds = strategyIds;
    }
}

package com.yunyou.dal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Liujinglin on 17/3/18.
 */
@Entity
public class StrategyCollection {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long strategyId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}

package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Strategy;
import com.yunyou.dal.entity.StrategyCollection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Liujinglin on 17/3/18.
 */
public interface StrategyCollectionDao extends PagingAndSortingRepository<StrategyCollection, Long> {

    @Override
    StrategyCollection save(StrategyCollection strategyCollection);

    @Modifying
    @Transactional
    @Query("update strategycollection set content=?1 where id=?2")
    int updateById(String strategyIds, Long id);

//    @Modifying
//    @Transactional
//    @Query("select strategyIds from strategycollection where userId = ?1")
//    String findByUserId(Long userId);

    StrategyCollection findByUserId(Long userId);
}

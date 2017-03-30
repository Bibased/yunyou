package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Strategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/18.
 */
public interface StrategyDao extends PagingAndSortingRepository<Strategy, Long> {
    @Override
    Strategy save(Strategy strategy);

    @Override
    Page<Strategy> findAll(Pageable pageable);

    List<Strategy> findByPublishIdIn(Collection<Long> ids);
    Page<Strategy> findByPublishIdIn(Collection<Long> ids, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update strategy s set s.isCollection = s.isCollection where d.id = ?1")
    void likeThisDynamic(Long strategyId);
}

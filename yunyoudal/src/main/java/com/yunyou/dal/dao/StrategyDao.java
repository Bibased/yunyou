package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Strategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/18.
 */
public interface StrategyDao extends JpaRepository<Strategy, Long> {
    @Override
    Strategy save(Strategy strategy);

    @Override
    Page<Strategy> findAll(Pageable pageable);

    Page<Strategy> findByPublisherIn(Collection<Long> Ids,Pageable pageable);

    Page<Strategy> findByCityIdsLike(String cityId,Pageable pageable);

    Page<Strategy> findByPublisherInAndCityIdsLike(Collection<Long> Ids,String cityId, Pageable pageable);
}

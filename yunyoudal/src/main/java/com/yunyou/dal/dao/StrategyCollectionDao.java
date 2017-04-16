package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Strategy;
import com.yunyou.dal.entity.StrategyCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Liujinglin on 17/3/18.
 */
public interface StrategyCollectionDao extends JpaRepository<StrategyCollection, Long> {

}

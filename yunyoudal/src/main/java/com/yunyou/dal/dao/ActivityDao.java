package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
public interface ActivityDao extends PagingAndSortingRepository<Activity, Long> {

    @Override
    Activity save(Activity activity);

    List<Activity> findByPublishIdIn(Collection<Long> Ids);

    Page<Activity> findByPublishIdIn(Collection<Long> Ids, Pageable pageable);

    @Override
    Page<Activity> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query("update activity set nowPeople = nowPeople + 1 where id = ?1")
    int updateById(Long activityId);
}

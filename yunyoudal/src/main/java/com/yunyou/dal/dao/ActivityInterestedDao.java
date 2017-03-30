package com.yunyou.dal.dao;

import com.yunyou.dal.entity.ActivityInterested;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
public interface ActivityInterestedDao extends PagingAndSortingRepository<ActivityInterested, Long> {
    @Modifying
    @Transactional
    @Query("update activityinterested set attentionIndex = ?3 where activityId = ?1 and userId = ?2")
    int updateByUserIdAndActivityId(Long activityId, Long userId, Integer attentionIndex);

    @Modifying
    @Transactional
    @Query("select attentionIndex from activityinterested where activityId = ?1 and userId = ?2")
    int findAttentionIndexByUserIdAndActivityId(Long activityId, Long userId);

    @Modifying
    @Transactional
    @Query("select activityId from activityinterested where userId = ?1 and attentionIndex = 1")
    List<Long> findActivityIdsByUserId(Long userId);

    @Override
    ActivityInterested save(ActivityInterested activityInterested);
}

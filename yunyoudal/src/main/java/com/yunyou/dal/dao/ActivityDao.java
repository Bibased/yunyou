package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
@Component
public interface ActivityDao extends JpaRepository<Activity, Long> {

    @Override
    Activity save(Activity activity);

    @Override
    Page<Activity> findAll(Pageable pageable);
    Page findByExpenseLessThanEqualAndStartTimeGreaterThanEqualAndDaysLessThanEqualAndPublisherInAndCityIdsLike(Integer expense, Date date,Integer days,Collection<Long> Ids,String cityCode, Pageable pageable);
    Page findByExpenseLessThanEqualAndStartTimeGreaterThanEqualAndDaysLessThanEqualAndCityIdsLike(Integer expense, Date date,Integer days, String cityCode,Pageable pageable);
}

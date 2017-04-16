package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Dynamic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


/**
 * Created by Liujinglin on 17/3/18.
 */
public interface DynamicDao extends JpaRepository<Dynamic, Long> {

    @Override
    Dynamic save(Dynamic userDynamic);

    @Override
    Page<Dynamic> findAll(Pageable pageable);

    Dynamic findById(Long id);
    Page<Dynamic> findByPublisherIn(Collection<Long> Ids,Pageable pageable);


}

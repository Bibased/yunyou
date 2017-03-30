package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Dynamic;
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
public interface DynamicDao extends PagingAndSortingRepository<Dynamic, Long> {

    @Override
    Dynamic save(Dynamic userDynamic);

    @Override
    List<Dynamic> findAll();

    @Override
    Page<Dynamic> findAll(Pageable pageable);

    Dynamic findById(Long id);
    List<Dynamic> findByPublishIdIn(Collection<Long> Ids);
    Page<Dynamic> findByPublishIdIn(Collection<Long> Ids,Pageable pageable);


    @Modifying
    @Transactional
    @Query("update Dynamic d set d.likeCount = d.likeCount+1 where d.id = ?1")
    void likeThisDynamic(Long dynamicId);

}

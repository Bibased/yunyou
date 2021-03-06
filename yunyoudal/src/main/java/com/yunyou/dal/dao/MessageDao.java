package com.yunyou.dal.dao;

import com.yunyou.dal.entity.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by dell on 2017/3/18.
 */

/**
 * findBy为前缀的方法spring会按字段名字解析，比如findByInfoUser根据userId查找，findByContent根据content字段查找，
 * 还可以加上And,Or,In,Not,NotIn,OrderBy,Like等。findByInfoUserIn根据userId在集合里查找，详情参考http://docs.spring.io/spring-data/jpa/docs/2.0.0.M1/reference/html/#jpa.query-methods.query-creation
 */
public interface MessageDao extends JpaRepository<Message,Long> {
    Message findByInfoUser(Long userId);
    List<Message> findByInfoUserIn(Collection<Long> infoUser);
    Page<Message> findByInfoUserIn(Collection<Long> infoUser,Pageable pageable);
    @Modifying
    @Transactional
    @Query("delete from Message m where m.infoUser=?1")
    void deleteByInfoUser(Long userId);
    @Modifying
    @Transactional
    @Query("update Message set content=?1 where id=?2")
    int updateById(String content,Long id);
    @Override
    List<Message> findAll(Sort sort);

    @Override
    Page<Message> findAll(Pageable pageable);

    @Override
    Message save(Message s);


    @Override
    Message findOne(Long aLong);

    @Override
    boolean exists(Long aLong);

    @Override
    List<Message> findAll();

    @Override
    List<Message> findAll(Iterable<Long> iterable);
    @Override
    long count();

    @Override
    void delete(Long aLong);

    @Override
    void delete(Message message);

    @Override
    void delete(Iterable<? extends Message> iterable);

    @Override
    void deleteAll();
}

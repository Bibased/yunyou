package com.yunyou.dal.dao;

import com.yunyou.dal.entity.City;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
public interface CityDao extends PagingAndSortingRepository<City, Long> {
    @Override
    City save(City city);

    @Override
    List<City> findAll();
}

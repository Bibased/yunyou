package com.yunyou.dal.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by Liujinglin on 17/3/19.
 */
@Entity
public class City {
    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private Strategy city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Strategy getCity() {
        return city;
    }

    public void setCity(Strategy city) {
        this.city = city;
    }
}

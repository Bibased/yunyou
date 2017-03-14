package com.yunyou.dal.entity;

import java.io.Serializable;

/**
 * Created by lds on 2016/12/18.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 7621305592543119629L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

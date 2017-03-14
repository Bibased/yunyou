package com.yunyou.dal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lds on 2016/12/18.
 */
@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 7621305592543119629L;
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

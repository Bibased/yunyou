package com.yunyou.dal.entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dell on 2017/3/18.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Message implements Serializable{
    private static final long serialVersionUID = 386532739580677509L;
    @Id
    @GeneratedValue
    private Long id;
    private Long infoUser;
    private Long publisher;
    private String content;
    private String anchorUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date infoTime;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(Long infoUser) {
        this.infoUser = infoUser;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    public String getAnchorUrl() {
        return anchorUrl;
    }

    public void setAnchorUrl(String anchorUrl) {
        this.anchorUrl = anchorUrl;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

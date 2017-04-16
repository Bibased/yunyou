package com.yunyou.dal.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lds on 2017/4/16.
 */
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue
    private Long id;
    private Long publisher;
    private Long chatRoom;
    //信息类型，1代表文本,2代表图片
    private Integer type;
    private String txtOrUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    public Long getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(Long chatRoom) {
        this.chatRoom = chatRoom;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTxtOrUrl() {
        return txtOrUrl;
    }

    public void setTxtOrUrl(String txtOrUrl) {
        this.txtOrUrl = txtOrUrl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

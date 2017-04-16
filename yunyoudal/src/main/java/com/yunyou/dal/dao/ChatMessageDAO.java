package com.yunyou.dal.dao;

import com.yunyou.dal.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lds on 2017/4/16.
 */
public interface ChatMessageDAO extends JpaRepository<ChatMessage,Long>{
}

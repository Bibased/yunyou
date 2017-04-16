package com.yunyou.dal.dao;

import com.yunyou.dal.entity.ChatMessage;
import com.yunyou.dal.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lds on 2017/4/16.
 */
public interface ChatRoomDAO extends JpaRepository<ChatRoom,Long>{
}

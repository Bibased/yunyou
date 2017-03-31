package com.yunyou.dal;

import com.yunyou.YunyouStarter;
import com.yunyou.dal.dao.MessageDao;
import com.yunyou.dal.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2017/3/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YunyouStarter.class)
public class MessageDAOTest {
    @Resource
    MessageDao messageDao;
    @Test
    public void testQuery(){
        //根据单个userId查询
        Message message =(messageDao.findByUserId(11L));
        //根据userId集合查询
        List<Long> userIds = Arrays.asList(11L,22L);
        List<Message> messageList = messageDao.findByUserIdIn(userIds);
        //根据userId集合分页查询
        PageRequest pageRequest = new PageRequest(0,10, Sort.Direction.ASC,"id");
        Page<Message> page = messageDao.findByUserIdIn(userIds,pageRequest);
        System.out.println();
    }
    @Test
    public void testSave(){
        Message message = new Message();
        message.setContent("33");
        message.setUserId(33L);
        messageDao.save(message);
    }
    @Test
    public void testDel(){
        messageDao.deleteByUserId(33L);
    }
    @Test
    public void testUpdate(){
        int aff = messageDao.updateById("test",1L);
        System.out.println(aff);
    }

}

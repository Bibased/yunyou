package com.yunyou.dal;

import com.google.gson.Gson;
import com.yunyou.YunyouStarter;
import com.yunyou.dal.dao.UserDAO;
import com.yunyou.dal.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YunyouStarter.class)
public class UserDAOTest {
	@Resource
	UserDAO userDAO;
	@Test
	public void testQuery() {

	}
	@Test
	public void testSave(){
		userDAO.save(new User("u","u"));

	}

}

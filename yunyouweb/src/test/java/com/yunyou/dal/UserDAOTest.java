package com.yunyou.dal;

import com.yunyou.dal.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
public class UserDAOTest {
	@Resource
	UserDAO userDAO;
	@Test
	public void testQuery() {


	}

}

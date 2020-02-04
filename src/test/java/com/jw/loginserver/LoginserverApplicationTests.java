package com.jw.loginserver;

import com.jw.loginserver.dao.User;
import com.jw.loginserver.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;


@SpringBootTest
class LoginserverApplicationTests {


	@Test
	void contextLoads() {

	}
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserMapper userMapper;

	@Test
	void test() {
		User user=userMapper.query(1);
		System.out.print(user);
	}
}

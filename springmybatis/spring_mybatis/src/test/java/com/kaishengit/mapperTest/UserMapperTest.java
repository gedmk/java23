package com.kaishengit.mapperTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaishengit.entity.User;
import com.kaishengit.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserMapperTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void save() {
		userService.save();	
	}
	@Test
	public void findById() {
		User user = userService.findById();
		System.out.println(user);
	}
	
}

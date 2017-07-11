package com.kaishengit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void save() {
		User user = new User("ÐÞÂÞ","123445","°µºÚ³Ç",2);
		userMapper.save(user);		
	}
	public User findById() {
		return userMapper.findById(1);
	}
	
}

package com.kaishengit.mapper;

import com.kaishengit.entity.User;

public interface UserMapper {

	void save(User user);
	User findById(Integer id);
	
}

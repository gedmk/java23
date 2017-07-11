package com.kaishengit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kaishengit.entity.User;

public interface UserMapper {
	
	//查找全部user
	@Select("select * from t_user")
	List<User> findAll();
	//查找一对多
	List<User> findUserAndAccount();
	//通过id查找user
	User findUserById(Integer id);
	//保存
	void save(User user);
	//插入多条
	void batchSave(List<User> userList);
	//通过账号和密码查询
	User findByUserNameAndPassword(String userName,
			   String password);
	
}

package com.kaishengit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kaishengit.entity.User;

public interface UserMapper {
	
	//����ȫ��user
	@Select("select * from t_user")
	List<User> findAll();
	//����һ�Զ�
	List<User> findUserAndAccount();
	//ͨ��id����user
	User findUserById(Integer id);
	//����
	void save(User user);
	//�������
	void batchSave(List<User> userList);
	//ͨ���˺ź������ѯ
	User findByUserNameAndPassword(String userName,
			   String password);
	
}

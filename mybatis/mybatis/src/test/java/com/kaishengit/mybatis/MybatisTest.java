package com.kaishengit.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;

public class MybatisTest {

	private Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Test
	public void findAll() throws Exception{
		//1.���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.����SqlSession����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.����SqlSession,
		SqlSession sqlSession = sqlSessionFactory.openSession();//sqlSessionFactory.openSession(true),��ʾ�Զ�commit
		//4.�������ݿ����
		List<User> userList = sqlSession.selectList("com.kaishengit.com.kaishengit.entity.UserMapper.findAll");
		for(User user : userList) {
			logger.debug("user:{}",user);
		}
		sqlSession.close();
	}
	
	
	
	
}

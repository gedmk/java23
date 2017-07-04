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
		//1.加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.创建SqlSession工厂
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.创建SqlSession,
		SqlSession sqlSession = sqlSessionFactory.openSession();//sqlSessionFactory.openSession(true),表示自动commit
		//4.进行数据库操作
		List<User> userList = sqlSession.selectList("com.kaishengit.com.kaishengit.entity.UserMapper.findAll");
		for(User user : userList) {
			logger.debug("user:{}",user);
		}
		sqlSession.close();
	}
	
	
	
	
}

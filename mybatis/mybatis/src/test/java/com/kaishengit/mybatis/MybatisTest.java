package com.kaishengit.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.MybatisUtil;
import com.mysql.fabric.xmlrpc.base.Array;

public class MybatisTest {

	private Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Test
	public void findAll() throws Exception{
		
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();//sqlSessionFactory.openSession(true),表示自动commit
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> userList = userMapper.findAll();
		for(User user : userList) {
			logger.debug("user:{}",user.getUserName());
		}
		sqlSession.close();
	}
	
	@Test
	public void findUserAndAccount() {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.findUserAndAccount();
		
		for(User user : userList) {
			logger.debug("user:{}",user.getUserName());
			logger.debug("account{}",user.getAccount().getName());
		}
		sqlSession.close();
	}
	
	@Test
	public void findUserById() {
		SqlSession sqlSession = null;
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
			sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.findUserById(1);
			logger.debug("user:{}",user);		
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			sqlSession.close();	
		}		
	}
	
	@Test
	public void save() {
		SqlSession sqlSession = null;
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
			sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setUserName("李四");
			user.setAddress("暗黑城");
			user.setPassword("123456");
			user.setAccountId(2);
			userMapper.save(user);
			
			sqlSession.commit();
			logger.debug("user{}",user);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	@Test
	public void batchSave(){
		SqlSession sqlSession = null;
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
			sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user1 = new User();
			user1.setUserName("李四");
			user1.setAddress("暗黑城");
			user1.setPassword("123456");
			user1.setAccountId(2);
			User user2 = new User();
			user2.setUserName("王五");
			user2.setAddress("牛");
			user2.setPassword("123456");
			user2.setAccountId(3);
			List<User> userList = new ArrayList<User>();
			userList.add(user1);
			userList.add(user2);
			userMapper.batchSave(userList);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}		
	}
	
	@Test
	public void findByUserNameAndPassword(){
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findByUserNameAndPassword("萧炎","232345");
		logger.debug("user:{}",user);
		sqlSession.close();
	}
	
	
	
}

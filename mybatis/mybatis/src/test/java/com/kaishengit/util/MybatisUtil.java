package com.kaishengit.util;

import java.io.IOException;
import java.io.Reader;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static SqlSessionFactory sqlSessionFactory = BuilderSessionFactory();

	private static SqlSessionFactory BuilderSessionFactory() {
		try {
			//1.加载配置文件
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			//2.创建SqlSessionFactory工厂
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			return sqlSessionFactoryBuilder.build(reader);
		} catch (IOException e) {
			throw new RuntimeException("读取Mybatis文件异常",e);
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	} 
	
}

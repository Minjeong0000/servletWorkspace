package com.kh.app.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessisonTemplate {

	public static SqlSession getSqlSession() throws Exception {
		//소스폴더안 드라이버 정보가 담긴 xml 경로. 
		String resource = "/conf.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory.openSession(false);

		
	}
	
	
}

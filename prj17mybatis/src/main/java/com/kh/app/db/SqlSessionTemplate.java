package com.kh.app.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	public static SqlSession getSession() throws Exception {
		String resource = "/conf.xml";//파일경로
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//팩토리 사용해서 세션 객체 얻어오기
		SqlSession ss = sqlSessionFactory.openSession(false);//오토커밋 끄기
		return ss;
	}
	
}

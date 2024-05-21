package com.kh.app.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JDBCTemplate {
	
	//////////mybatis////////////
	public static SqlSession getSqlSession() throws Exception {
		String resource = "/abc.xml";//경로바꿔주기
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession ss = sqlSessionFactory.openSession(false);//false값으로 변경해서 오토커밋 끄기
		return ss;
	}
	////////////////////////
	public static Connection getConnection() throws Exception {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      String url = "jdbc:oracle:thin:@localhost:1521:XE";
	      String id = "C##SEMI";
	      String pwd = "1234";
	      Connection conn = DriverManager.getConnection(url, id, pwd);
	      conn.setAutoCommit(false);
	      return conn;
	   }
	   
	   public static void commit(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.commit();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void rollback(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.rollback();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(Statement stmt) {
	      try {
	         if(stmt != null && !stmt.isClosed()) {
	            stmt.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(ResultSet rs) {
	      try {
	         if(rs != null && !rs.isClosed()) {
	            rs.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
}

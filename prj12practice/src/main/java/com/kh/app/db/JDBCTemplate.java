package com.kh.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {

	public static Connection getConnection () throws Exception {
		//드라이버 경로
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id= "C##KH";
		String pwd = "1234";
		//드라이버매니저에 url id pwd담아서 connection객체에 저장
		Connection conn = DriverManager.getConnection(url,id,pwd);
		conn.setAutoCommit(false);
		return conn;
	}
	
}

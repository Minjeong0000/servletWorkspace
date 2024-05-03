package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardDao {

	//게시글 작성
	public int insert(BoardVo vo) throws Exception {
		//conn

		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		String sql ="INSERT INTO BOARD (TITLE,CONTENT) VALUES(?,?)";
		
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		
		if(result ==1) {
			conn.commit();
		}
		
		//result
		return result;
	}//method

	public List<BoardVo> selectBoardList() throws ClassNotFoundException, SQLException {

		//conn 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String id ="C##KH";
		String pwd ="1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		conn.setAutoCommit(false);
		//sql
		String sql = "SELECT * FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> voList = new ArrayList<BoardVo>();
		
		while(rs.next()) {
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			voList.add(vo);
		}
		//result
	
	return voList;
	}
	
	
}//class

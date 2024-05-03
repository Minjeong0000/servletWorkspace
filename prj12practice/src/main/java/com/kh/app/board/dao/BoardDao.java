package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.db.JDBCTemplate;
import com.kh.board.vo.BoardVo;

public class BoardDao {
	//게시글 작성. insert쿼리문 실행하므로 리턴값 정수형
	public int insert(BoardVo vo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql = "INSERT INTO BOARD (TITLE, CONTENT) VALUES (?,?)";
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		
		if(result ==1 ) {
			conn.commit();
		}
		//result		
		return result;
	}//method
	
	public List<BoardVo>selectBoardList() throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql = "SELECT * FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//보드리스트만들기
		List<BoardVo>voList = new ArrayList<>();
		//반복문
		while(rs.next()) {
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			voList.add(vo);
		}
		return voList;
	}
	
}//class

package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardDao {

	
	//게시글 작성
	public int insertBoard(Connection conn,BoardVo vo) throws Exception {
		
		String sql = "INSERT INTO BOARD_TEMP (TITLE, CONTENT)VALUES(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());

		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);//connection을 여기서 닫으면 서비스에서 트랜잭션 못함. pstmt만 닫기
		return result;
	}
	
	
	//게시글 목록(을 리턴) 조회
	public List<BoardVo> getBoardList(Connection conn) throws Exception{
		String sql = "SELECT * FORM BOARD_TEMP";
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
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}
	
	
	
	
}

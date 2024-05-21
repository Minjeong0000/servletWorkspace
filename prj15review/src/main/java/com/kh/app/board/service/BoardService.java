package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardService {

	private final BoardDao dao;
	
	public BoardService() {
		this.dao = new BoardDao();
	}
	
	//게시글 작성 
	public int insertBoard(BoardVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertBoard(conn,vo);
		
		
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public List<BoardVo>getBoardList() throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		List <BoardVo> voList = dao.getBoardList(conn);
		
		JDBCTemplate.close(conn);
		return voList;
	}
	
	
}

package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardService {

	private final BoardDao dao;
	public BoardService() {
		this.dao= new BoardDao();
	}
	
	
	//게시글 작성
	public int insertBoard(BoardVo vo) throws Exception {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		int result = dao.insertBoard(ss, vo);
		if(result ==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
			ss.close();
			return result;
	}

	
	//게시글 목록 조회
	public List<BoardVo>getBoardList() throws Exception{
		SqlSession ss = JDBCTemplate.getSqlSession();
		List<BoardVo>voList = dao.getBoardList(ss);
		ss.close();
		return voList;
	}
	
	
}


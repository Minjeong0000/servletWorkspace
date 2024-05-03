package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;
import com.kh.app.db.JDBCTemplate;
import static com.kh.app.db.JDBCTemplate.*;

public class BoardService {
	//dao갔다오는작업은 자주할거니까 필드로 빼놓기
	private final BoardDao dao;
	public BoardService() {
		dao = new BoardDao();
	}

	
	//게시글작성
	public int insert(BoardVo vo) throws Exception {
		//비즈니스로직
		if(vo.getTitle().contains("나쁜말")) {
			throw new Exception("욕하지마세요-제목");
		}
		if(vo.getContent().contains("욕설")) {
			throw new Exception("욕하지마세요-내용");
		}
		
		//dao호출
		Connection conn = getConnection();
		int result = dao.insert(conn,vo);
		
		if(result==1) {
			commit(conn);
		}else {
			rollback(conn);
		}close(conn);
		return result;
	}


	//게시글목록
	public List<BoardVo> selectBoardList()throws Exception{

		//dao 호출
		Connection conn = getConnection();
		List<BoardVo>voList = dao.selectBoardList(conn);
		close(conn);
		return voList;
	}

	

	
}

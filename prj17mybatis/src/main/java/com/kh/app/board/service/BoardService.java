package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.SqlSessionTemplate;

public class BoardService {
	
	private final BoardDao dao;
	public BoardService() {
		this.dao = new BoardDao();
	}

	//게시글 작성
	public int write(BoardVo vo) throws Exception {
		//SqlSession Template에서 sql세션 얻어오기
		SqlSession ss = SqlSessionTemplate.getSession();
		int result = dao.write(ss, vo);
		//트랜잭션,클로즈 진행
		if(result==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
		
	}
	
	//게시글 조회
	public List<BoardVo> getBoardList() throws Exception{
		SqlSession ss = SqlSessionTemplate.getSession();
		List<BoardVo>voList = dao.getBoardList(ss);
		
		//select이므로 트랜잭션은 필요 없음, close만
		ss.close();
		
		return voList;
	}
	
}

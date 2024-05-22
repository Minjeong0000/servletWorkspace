package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.SearchVo;
import static com.kh.app.db.SqlSessisonTemplate.getSqlSession;

public class BoardService {
	private final BoardDao dao;
	public BoardService() {
		this.dao = new BoardDao();
	}
	
	
	
	//게시글 작성
	public int write(BoardVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		int result = dao.write(ss, vo);
		if(result ==1 ) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
	
	}
	//게시글 목록 조회
	public List<BoardVo>getBoardList(SearchVo vo) throws Exception{
		SqlSession ss = getSqlSession();
		List<BoardVo>voList = dao.getBoardList(ss , vo);
		ss.close();
		return voList;
	}
	
	
	//게시글 검색(제목)
	public List<BoardVo>getBoardListByTitle(SearchVo vo) throws Exception{
		SqlSession ss = getSqlSession();
		List<BoardVo>voList = dao.getBoardListByWriter(ss, vo);
		ss.close();

		return voList;
	}
	
	//게시글 검색(내용)
	public List<BoardVo>getBoardListByContent(SearchVo vo) throws Exception{
		SqlSession ss = getSqlSession();
		List<BoardVo>voList = dao.getBoardListByWriter(ss, vo);

		ss.close();
		return voList;


	}
	//게시글 검색(작성자)
	public List<BoardVo>getBoardListByWriter(SearchVo vo) throws Exception{
		SqlSession ss = getSqlSession();
		List<BoardVo>voList = dao.getBoardListByWriter(ss, vo);
		
		ss.close();
		return voList;

	}	
	
}

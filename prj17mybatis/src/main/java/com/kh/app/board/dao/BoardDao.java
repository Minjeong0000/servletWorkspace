package com.kh.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	//게시글 작성
	public int write(SqlSession ss,BoardVo vo) {
		return ss.insert("BoardMapper.write",vo);
	}
	
	//게시글 조회
	public List<BoardVo> getBoardList(SqlSession ss){
		return ss.selectList("BoardMapper.getBoardList");
		
	}
	
	
}

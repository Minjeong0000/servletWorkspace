package com.kh.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardReplyVo;

public class BoardReplyDao {

	//댓글 작성
	public int writeReply(SqlSession ss, BoardReplyVo vo) {
							//매퍼경로,댓글 정보 넘겨줄 vo
		System.out.println("dao > vo : " + vo);
			return ss.insert("BoardReplyMapper.writeReply",vo);
		
	}
	
	//댓글 목록조회
	public List<BoardReplyVo> getReplyAllByBoardNo(SqlSession ss, String refNo){
		return ss.selectList("BoardReplyMapper.selectReplyAllByBoardNo", refNo);
	}
	
	
}

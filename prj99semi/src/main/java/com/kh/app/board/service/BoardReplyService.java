package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static com.kh.app.db.SqlSessionTemplate.getSqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.dao.BoardReplyDao;
import com.kh.app.board.vo.BoardReplyVo;

public class BoardReplyService {

	private final BoardReplyDao dao;
	public BoardReplyService() {
		dao = new BoardReplyDao();
	}
	
	//댓글작성
		public int writeReply(BoardReplyVo vo ) throws Exception {
			SqlSession ss = getSqlSession();
			int result = dao.writeReply(ss,vo);
			
			
			if(result ==1) {
				ss.commit();				
			}else {
				ss.rollback();
			}
				ss.close();
				return result;
			
		}
	
	
	
	//댓글목록조회
	
		public List<BoardReplyVo>getReplyAllByBoardNo(String refNo) throws Exception{
			SqlSession ss = getSqlSession();
			List<BoardReplyVo>replyVoList = dao.getReplyAllByBoardNo(ss, refNo);
			ss.close();
			return replyVoList;
		}
		
		
	
}

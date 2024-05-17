package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.AttachmentVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.board.vo.PageVo;
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
	public int insert(BoardVo vo, List<AttachmentVo>attVoList) throws Exception {
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
		
		int attResult = 1;
		
		if(attVoList.size() >0) {
			attResult = dao.insertBoardAttachMent(conn,attVoList);
		}
		
		
		if(result* attResult >=1) {
			commit(conn);
		}else {
			rollback(conn);
		}close(conn);
		return result*attResult;
	}


	//게시글목록
	public List<BoardVo> selectBoardList(PageVo pvo)throws Exception{

		//dao 호출
		Connection conn = getConnection();
		List<BoardVo>voList = dao.selectBoardList(conn, pvo);
		close(conn);
		return voList;
	}


	public BoardVo getBoardByNo(String no,boolean isSelf) throws Exception {
		//비즈니스로직
		
		//dao호출
		Connection conn =null;//try-finally로 감싸면 변수인식못함.필드로 빼기
		BoardVo vo = null;
		
		try {
			conn = getConnection();

			int result = 1;
			if(!isSelf) {
				result = dao.increaseHit(conn,no);
			}
			vo = dao.getBoardByNo(conn,no);

			if(result == 1 && vo!=null) {
				commit(conn);
			}else {//해당 게시글이 없거나 잘못된 조회
				rollback(conn);
				throw new Exception ("[ERROR-B001]게시글 조회수 증가 실패....");
			}
		}
		finally {
			close(conn);//커넥션 닫는 작업은 무조건 시행되도록
		}
		return vo;
	
	}


	public List<CategoryVo> getCategoryVoList() throws Exception {

		Connection conn = getConnection();
		List<CategoryVo>categoryVoList = dao.getCategoryVoList(conn);
		close(conn);
		return categoryVoList;
		
		
		
	}


	public int edit(BoardVo vo) throws Exception {
		//비즈니스로직
		if(vo.getTitle().contains("18")){
			throw new Exception("욕ㄴㄴ");
		}
		if(vo.getContent().contains("18")) {
			throw new Exception("dfs");
			}
		//dao호출	
	
		Connection conn = getConnection();
		int result = dao.edit(conn,vo);
		
		if(result ==1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int delete(BoardVo boardVo) throws Exception {
		//비즈니스로직=>할거없음 스킵
		//dao호출
		Connection conn = getConnection();
		int result = dao.delete(conn,boardVo);
		
		if(result==1) {
			commit(conn);
		}else {
			rollback(conn);
			throw new Exception("게시글 삭제 실패...");
		}
		close(conn);
		return result;
		
	}


	public int getBoardCnt() throws Exception{

		//biz
		
		//sql
		Connection conn = getConnection();
		int cnt = dao.getBoardCnt(conn);
		close(conn);
		return cnt;
		
	}


	public List<AttachmentVo> getAttachment(String no) throws Exception {
		//biz없음
		//DAO호출
		Connection conn= getConnection();
		List<AttachmentVo> attVoList= dao.getAttachment(conn,no);
		close(conn);
		return attVoList;
		
		
		
	
	
	}


//카테고리 목록 조회


	
	


	

	

	
}

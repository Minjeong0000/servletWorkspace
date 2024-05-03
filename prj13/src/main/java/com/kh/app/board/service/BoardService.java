package com.kh.app.board.service;

import java.sql.Connection;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardService {

	public int insert(BoardVo vo) throws Exception {

		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		BoardDao dao = new BoardDao();
		int result = dao.insert(conn, vo);//insert호출할때 conn,vo같이넘김
		
		if(result==1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		
		return result;
	}//mehtod

}//class

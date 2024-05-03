package com.kh.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.dao.BoardDao;
import com.kh.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//복잡한 작업(db가서 table의 데이터조회하기)
		BoardDao dao = new BoardDao();
		List<BoardVo> voList = new ArrayList<BoardVo>();
		try {
			voList = dao.selectBoardList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//메소드만들기
	
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}

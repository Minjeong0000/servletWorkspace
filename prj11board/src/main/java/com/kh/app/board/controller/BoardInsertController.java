package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{

	//게시글 작성(화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	
	}
	//게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//복잡한 작업
		int result =1; //new BoardDao().insert(데이터);//데이터에 title,content 객체로 뭉쳐 담기
		//결과처리==(문자열 내보내기)
		if(result == 1 ) {
			req.setAttribute("msg", "게시글 작성 성공");
		}else {
			req.setAttribute("msg", "게시글 작성 실패");
		}
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}
}

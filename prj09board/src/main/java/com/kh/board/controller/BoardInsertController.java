package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{

	//게시글 작성하기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	//게시글 작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터
		String title = req.getParameter("title");
		String content = req.getParameter("title");
		
		//데이터 뭉치기
		
		BoardVo vo = new BoardVo(title,content);
		//디비
//		int inresult = new BoardDao().insert(~~~);
		
		int result = 1;
		
		//결과
		String msg = "";
		if(result == 1) {
			msg = "게시글 작성 성공 !";
		}else {
			msg = "게시글 작성 실팰..";
		}
		
		req.setAttribute("x", msg);
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		
	}
	
//		String x = req.getMethod();
//		if(x== "get") {
//			doGet(req,resp);
//		}else if(x=="post"){
//			doPost(req,resp);
//		}else if(x=="delete") {
//			doDelete(req,resp);
//		}else if(x=="put") {
//			doPut(req,resp);
//		}
		
	
}

package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			BoardService bs = new BoardService();
			int result = bs.insertBoard(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : "+ result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	
	}
	
	
}

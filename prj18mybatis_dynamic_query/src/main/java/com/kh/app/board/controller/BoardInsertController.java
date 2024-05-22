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

@WebServlet("/board/write")
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
			String writer = req.getParameter("writer");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);
			
			BoardService bs = new BoardService();
			int result = bs.write(vo);
			PrintWriter out = resp.getWriter();
			out.write("result:"+result);
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		
	}
	
}

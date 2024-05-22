package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.SearchVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String type = req.getParameter("type");
			String value = req.getParameter("value");
			
			SearchVo vo = new SearchVo();
			vo.setType(type);
			vo.setValue(value);
			
			BoardService bs = new BoardService();
			List<BoardVo>voList = bs.getBoardList(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("voList : " +voList);
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

	
}

package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.service.BoardReplyService;
import com.kh.app.board.vo.BoardReplyVo;
@WebServlet("/board/reply/list")
public class ReplyListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String refNo = req.getParameter("refNo");
			BoardReplyService service = new BoardReplyService();
			List<BoardReplyVo> replyVoList = service.getReplyAllByBoardNo(refNo);
			
			Gson gson = new Gson();
			String str = gson.toJson(replyVoList);//객체를Json형식의 문자열로 자동변환하는 메소드
			
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			System.out.println("str : " + str);
			out.write(str);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
}

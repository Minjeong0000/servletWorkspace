package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.dao.BoardReplyDao;
import com.kh.app.board.service.BoardReplyService;
import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardReplyVo;
import com.kh.app.member.vo.MemberVo;
@WebServlet("/board/reply/write")
public class ReplyWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String content = req.getParameter("content");
			String refNo = req.getParameter("refNo");
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			String wrtierNo = loginMemberVo.getNo();
			
			BoardReplyVo replyVo = new BoardReplyVo();
			replyVo.setContent(content);
			replyVo.setRefNo(refNo);
			replyVo.setWriterNo(wrtierNo);
			
			BoardReplyService service = new BoardReplyService();
			int result = service.writeReply(replyVo);
			PrintWriter out = resp.getWriter();
			out.write("result: "+result);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

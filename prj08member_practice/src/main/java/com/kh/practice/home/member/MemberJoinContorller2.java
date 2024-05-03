package com.kh.practice.home.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.practice.home.membervo.MemberVo;

@WebServlet("/member/join2")
public class MemberJoinContorller2 extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
				String memberId = req.getParameter("memberId");
				String memberPwd = req.getParameter("memberPwd");
				String memberPwdCheck = req.getParameter("memberPwdCheck");
				String memberNick = req.getParameter("memberNick");
				
				//데이터 뭉치기
				MemberVo vo = new MemberVo(memberId,memberPwd,memberNick);
		
	}
}

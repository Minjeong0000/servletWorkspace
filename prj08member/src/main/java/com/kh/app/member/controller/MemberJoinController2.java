package com.kh.app.member.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join2")
public class MemberJoinController2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberPwdCheck = req.getParameter("memberPwdCheck");
		String memberNick = req.getParameter("memberNick");
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo(memberId, memberPwdCheck, memberNick);
		
//		//복잡한 작업
//		if(!memberPwd.equals(memberPwdCheck)) {
////		회원가입실패 => 디비에 저장 안함,화면에 실패 문구 띄우기
//			
//		}else {
////		회원가입성공 => 디비에 저장
//		}
		
		String pwd1 = req.getParameter("memberPwd");
		String pwd2 = req.getParameter("memberPwdCheck");
		String msg = "";
		//모든 데이터의 유효성 검사를 통과하고, 디비에 insert한 결과값이 1이라고 나온 경우
		if(pwd1.equals(pwd2)){
			msg = "성공!";
		}else{
			msg = "실패....";
		}
		req.setAttribute("x", msg);//x라는 변수에 msg담아 보내기
		//결과처리 ==문자열 내보내기
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		
		
	}
	
}

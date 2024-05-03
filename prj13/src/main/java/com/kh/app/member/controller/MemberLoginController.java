package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	//로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = req.getParameter("memberId");//ID로쓰지않게조심
		String memberPwd = req.getParameter("memberPwd");
		
		//데이터뭉치기
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		
		//복잡한 작업=>서비스
		MemberService ms = new MemberService();
		MemberVo loginMemberVo;
		try {
			loginMemberVo = ms.login(vo);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "로그인 하는 중 에러 발생함~~!!");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			//여기서 포워딩하고 끝이 아니라 갔다가 다시 와서 아래 코드 실행함. return삽입해서 아래코드 실행 방지
			return;
		}
		
		//결과
		
		if(loginMemberVo != null) {
			req.setAttribute("msg", "로그인 성공");
		}else {
			req.setAttribute("msg", "로그인실패");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}
	
	
}

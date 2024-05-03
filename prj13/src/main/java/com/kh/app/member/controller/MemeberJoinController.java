package com.kh.app.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemeberJoinController extends HttpServlet {
	// 회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);

	}

	// 회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 꺼내기 v->c
//		req.setCharacterEncoding("UTF-8"); 필터가대신
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberPwd2 = req.getParameter("memberPwd2");
		String memberNick = req.getParameter("memberNick");
		
		//객체 데이터뭉쳐서 서비스클래스로 넘겨주기
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		vo.setMemberPwd2(memberPwd2);
		vo.setMemberNick(memberNick);
		
		
		MemberService ms = new MemberService();
		int result = 0;
		try {
			result = ms.join(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("회원가입 하다가 에러 발생...");
		}
		
		
		// 결과 c->v
		if (result == 1) {
			req.setAttribute("msg", "회원가입 성공!");

		} else {

			req.setAttribute("msg", "회원가입 실패...");
		}

		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);

	}

}

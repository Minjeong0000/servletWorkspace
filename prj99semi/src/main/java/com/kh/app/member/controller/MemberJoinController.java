package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	
	}
	
	//회원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데이터꺼내기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String nick = req.getParameter("nick");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setPwd2(pwd2);
			vo.setNick(nick);
			
			//서비스호출(하기 전에 데이터뭉쳐서 넘겨주기)
			
			MemberService ms = new MemberService();
			int result = ms.join(vo);

		
			//결과처리
			if(result ==1) {
				req.setAttribute("resultMsg","회원가입 성공!!");
			}else {
				req.setAttribute("resultMsg","회원가입 실패!!");
			}
			//공통로직 if문 밖에다 빼기
//			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
			resp.sendRedirect("/app/member/login");
			
		}catch(Exception e) {
			System.out.println("[ERROR-M001]"+e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}//method
	
	
}

package com.kh.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.vo.MemberVo;

@WebServlet(value="/login")
public class MemberController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//해당 key값에 대응하s는 value값 가져옴
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		MemberVo vo = new MemberVo(memberId,memberPwd);
		
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<style>");
		resp.getWriter().write("h1{");
		resp.getWriter().write("background-color:gray;");
		resp.getWriter().write("}");
		resp.getWriter().write("</style>");
		
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<h1>환영합니다~~!</h1>");
		resp.getWriter().write("<h1>");
		resp.getWriter().write(vo.getMemberId()+"님 로그인 성공");
		resp.getWriter().write("</h1>");
		resp.getWriter().write("</html>");
		
		
	}
	
}

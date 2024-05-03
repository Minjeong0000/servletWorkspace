package com.kh.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value ="/login")
public class MemberController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		MemberVo vo = new MemberVo(memberId,memberPwd);
		
	      resp.getWriter().write("<html>");
	      resp.getWriter().write("<head>");
	      resp.getWriter().write("<style>");
	      resp.getWriter().write("h1 {");
	      resp.getWriter().write("   background-color:gray;");
	      resp.getWriter().write("}");
	      resp.getWriter().write("</style>");
	      resp.getWriter().write("</head>");
	      resp.getWriter().write("<body>");
	      resp.getWriter().write("<h1>hello ~~~ !</h1>");
	      resp.getWriter().write("<h1>");
	      resp.getWriter().write(vo.getMemberId() + " mr.wellocome !");
	      resp.getWriter().write("</h1>");
	      resp.getWriter().write("</body>");
	      resp.getWriter().write("</html>");
	      
	}
}

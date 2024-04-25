package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login2")
public class MemberLoginController2 extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//패킷의 데이터 꺼내기
	String memberId = req.getParameter("memberId");//로그인했을때주소창에 나온 key값 그대로 써야 함
	String memberPwd = req.getParameter("memberPwd");//로그인했을때주소창에 나온 key값 그대로 써야 함
	/*확인
	System.out.println("꺼내온데이터: ");
	System.out.println(memberId);
	System.out.println(memberPwd);
	*/
	//복잡한 작업//id가 user01 이고 pwd가 1234이면 성공
	if(memberId.equals("user01") && memberPwd.equals("1234")) {
		//문자열 내보내기(jsp사용해서)
		req.setAttribute("msg", "성공!");
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}else {
		req.setAttribute("msg", "실패!");
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}
	
}
}

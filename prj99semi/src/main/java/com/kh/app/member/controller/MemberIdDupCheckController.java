package com.kh.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;

@WebServlet("/member/id-dup")
public class MemberIdDupCheckController extends HttpServlet {

	//아이디 중복 검사=>아이디 받아와서 db에서 조회하고 사용가능한지 알려주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			//데꺼
			String id = req.getParameter("id");
			
			//서비스
			MemberService ms = new MemberService();
			boolean isAvailable = ms.checkIdDup(id);
			
			//결과
			
			//문자열내보내기
			//전달받은 아이디를 이용하여 디비에 존재하는지 검사
			if(!isAvailable) {

				throw new Exception("중복검사 실패");
				}
				resp.getWriter().write("good");
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("bad");
		}
		
		
	}//method
	
	//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
	} 
	
	
	
	
}

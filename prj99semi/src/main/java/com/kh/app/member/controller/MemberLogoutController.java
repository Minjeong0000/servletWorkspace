package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그아웃처리는 세션을 없애면 됨
		HttpSession session = req.getSession();
		session.invalidate(); // 세션만료시키는 작업

//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		// 리다이렉트???
		// 클라이언트가 해당 리다이렉트 주소로 요청을 보냄
		resp.sendRedirect("/app/home");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}

package com.kh.app.home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = {"/" ,"/home"} )
public class HomeController extends HttpServlet{

	@Override

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//문자열 내보내기
	req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
	}
}

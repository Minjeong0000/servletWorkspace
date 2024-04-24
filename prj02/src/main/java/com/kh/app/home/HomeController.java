package com.kh.app.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/home")
public class HomeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터꺼내기
		String name = req.getParameter("name");

		//다양한 작업
		long time = System.currentTimeMillis();
		Date date = new Date();
		
		
		
		
		
		// 문자열 내보내기
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("<h1>홈페이지</h1>");
		if (name != null) {
			out.write("<h1>" + name + "님 환영합니다</h1>");

		} else {
			out.write("<h1>게스트님 환영합니다.</h1>");
		}
		out.write("<button onclick = 'alert(\"안녕하세요\")'>안녕</button>");
		
		out.write("<hr>");
		
		out.write("<h3>");
		out.write("time :"+time);
		out.write("<h3>");
		
		out.write("<h3>");
		out.write("date :"+date);
		out.write("<h3>");
	}

}

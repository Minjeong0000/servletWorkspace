package com.kh.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value ="/test")
public class TestController extends HttpServlet {
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 //클라이언트가 보낸 데이터 꺼내기
	 String str =req.getParameter("num");
	 System.out.println("클라이언트가 보낸 데이터 중 key값이 num 인 데이터 : "+str);
	 
	 
	 //클라이언트한테 응답하기(==문자열 내보내기)
	 PrintWriter pw = resp.getWriter();		//클라이언트와 연결된 통로 얻기
	 pw.write("<h1>asdfasdfasfasdfasf</h1>");						//통로 이용해서 문자열 내보내기
	 
	 
}
	
	
}

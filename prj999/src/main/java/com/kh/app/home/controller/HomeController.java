package com.kh.app.home.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.controller.MemberController;


//대장서블릿(dispatcherServlet).모든 url에 대한 요청을 처리
@WebServlet("/*")
public class HomeController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HomeController.service() called...");
		
		//요청들어온 url 확인
		String url = req.getRequestURL().toString();
		System.out.println("url : "+ url);
		//요청들어온 방식 확인
		String method = req.getMethod();
		System.out.println("method: "+ method);
		
		
		MemberController mc = new MemberController();
		
		
		Map<String,Object>reqMap= new HashMap<String,Object>();
		//key-value
		reqMap.put("/member", new MemberController());
		Object obj = reqMap.get(url);
		
		obj.method~~~(req);
		
		
		//url만가지고  url,요청들어온method 구분->메소드호출
		//url이 어떤 식으로 끝나는지
		String str = "";
		if(url.endsWith("member/login")) {
			str = mc.login();
			
		}else if(url.endsWith("member/join")&& method.equals("POST")) {
			str = mc.join();
			
		}else if(url.endsWith("member/join")&& method.equals("GET")) {
			str = mc.join();
		
		}
		
		req.getRequestDispatcher("/WEB-INF/views/"+str+".jsp").forward(req,resp);		
		
	}
	
	
	
	
}

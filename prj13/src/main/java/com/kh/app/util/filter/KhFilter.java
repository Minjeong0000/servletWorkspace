package com.kh.app.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.sun.net.httpserver.Filter.Chain;

@WebFilter("/*")//모든 요청에 대해 필터링적용
public class KhFilter implements Filter {
//필터상속받고 오버라이드 진행
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		/*
		if(현재로그인유저의정보==관리자) {
			다음으로 =>chain.doFilter(request, response);
		}else {
			진행멈춤 
			request.getRD("에러페이지.").forward(req,res);
		}
		*/
		
		System.out.println("필터에 요청 들어옴~~");
		chain.doFilter(request, response);
	}	
	
}//class

package com.kh.app.member.controller;



public class MemberController {
	
	public String login() {
		System.out.println("로그인~~");
		return "common/result";
		
	}
	
	
	//join /POST
	public String join() {
		System.out.println("회원가입~~");
		return "member/loginPage";
	}
	
	public String joinView() {
		System.out.println("회원가입화면~~");
		
	}
	
	
	
	
}



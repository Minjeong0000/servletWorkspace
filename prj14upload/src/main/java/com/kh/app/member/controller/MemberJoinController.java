package com.kh.app.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(
		maxFileSize = 1024*1024*10,
		maxRequestSize = 1024*1024*50,
		fileSizeThreshold = 1024*1024*10
		)
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");

		//파일은 getParameter로 꺼낼 수 없다. getPart사용
		Part f =req.getPart("f");

		System.out.println("id : "+ id);
		System.out.println("pwd : "+ pwd);
		System.out.println("nick : "+ nick);
		System.out.println("f(part):"+ f);
		
		//파일 객체(Part)로부터 필요한 데이터를 꺼냄
		//원본파일명
		String originName = f.getSubmittedFileName();
		long fileSize = f.getSize();
		InputStream is = f.getInputStream();
		
//		System.out.println(originName); 파일이름확인
//		System.out.println(fileSize); 파일사이즈확인(byte)
		
		//파일아웃풋스트림준비
		String path = "D:\\dev\\servletWorkspace\\prj14upload\\src\\main\\webapp\\resources\\upload\\";
	      String random = UUID.randomUUID().toString();
	      String ext = originName.substring(originName.lastIndexOf("."));
	      String changeName = System.currentTimeMillis() + "_" + random + ext;
	      FileOutputStream fos = new FileOutputStream(path + changeName);
		
		//buf =>1024byte가 들어가는 바구니.
		byte[]buf = new byte[1024];
		//읽고 내보내는 과정 반복문으로 처리
		int size = 0;
		//inputstream에서 데이터읽어오기
		while((size = is.read(buf)) != -1) {//값이 -1이면 한줄한줄 읽어오는 작업이 끝난거임
			//내보내기
			fos.write(buf, 0 , size);
		}
		is.close();//inputstream닫기
		fos.close();//fileoutputstream닫기
		
	}
	
}

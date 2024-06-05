package com.kh.app.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String num = req.getParameter("num");
			
			//service
			NoticeService service = new NoticeService();
			NoticeVo noticeVo = service.getNotice(num);
			//result
			PrintWriter out = resp.getWriter();
			out.write("noticeVo: "+ noticeVo);
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}

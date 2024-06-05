package com.kh.app.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.admin.vo.AdminVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/notice/write")
public class NoticeWriteController extends HttpServlet{

	//작성하기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.getRequestDispatcher("/WEB-INF/views/notice/write.jsp").forward(req, resp);

		
	
	}
	
	
	//작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		HttpSession session =req.getSession();
//		AdminVo loginAdminVo =(AdminVo)session.getAttribute("loginAdminVo");
//		String writerNo = loginAdminVo.getNo();

		
		try {
			
			String title = req.getParameter("title");
			String content= req.getParameter("content");
			String writerNo = "1"; //req.getParameter("writerNo");
			
			NoticeVo vo = new NoticeVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			
			//service
			
			NoticeService service = new NoticeService();
			int result = service.write(vo);
			

			PrintWriter out = resp.getWriter();
			out.write("result: "+result);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

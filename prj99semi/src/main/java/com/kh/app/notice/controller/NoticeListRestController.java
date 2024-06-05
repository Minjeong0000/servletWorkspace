package com.kh.app.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.vo.PageVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/rest/notice/list")
public class NoticeListRestController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//service
			NoticeService service = new NoticeService();

			//페이지만들기
			//data
			String pno_ =req.getParameter("pno");//"pno"ajax로 넘길 데이터
			int pno = Integer.parseInt(pno_);
			
			int listCount= service.getNoticeCount();
			//현재페이지
			int currentPage = pno;
			//페이지개수
			int pageLimit=5;
			//1~10게시글
			int boardLimit=10;
			
			PageVo pvo = new PageVo(listCount,currentPage,pageLimit,boardLimit);
			
//			/(매개변수로 페이지전달)
			List<NoticeVo> voList = service.getNoticeList(pvo);
			
			//result
			
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(voList);
			resp.setContentType("application/json; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
//			req.setAttribute("voList",voList);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
	
	
}

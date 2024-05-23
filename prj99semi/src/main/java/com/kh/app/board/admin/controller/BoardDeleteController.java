package com.kh.app.board.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;

@WebServlet("/admin/board/delete")
public class BoardDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			//여러개의 데이터가 넘어올 때 no라는 키값에 해당하는 모든 값을 가져와서 배열로 만들어줌
			String[] noArr = req.getParameterValues("no");
			
			
			//service
			BoardService bs = new BoardService();
			int result = bs.delete(noArr);
			
			//result
			if(result<1) {
				throw new Exception();
			}
			req.getSession().setAttribute("alertMsg", "게시글"+noArr.length+"개 삭제 성공");
			resp.sendRedirect("/app/board/list");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//method
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	}
	
}

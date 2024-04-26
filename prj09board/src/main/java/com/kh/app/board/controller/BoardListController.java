package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list") // 목록조회'만'할 것이므로 get/post안 나눠도 됨(get만 할거임)
public class BoardListController extends HttpServlet {
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//디비에서 데이터 가져오기
//	List<BoardVo> boardVoList = new BoardDao().selestBoardList();	
	//결과처리==문자열 내보내기 jsp에게 넘겨주면서
//	req.setAttribute("boardVoList", boardVoList);
	req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//잘못된요청
	}

}

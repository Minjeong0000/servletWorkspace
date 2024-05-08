package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{

	//작성화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			BoardService bs = new BoardService();
			List<CategoryVo> categoryVoList = bs.getCategoryVoList();
			req.setAttribute("categoryVoList", categoryVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
			
		}
		
	
	}
	
	
	//작성하고데이터받기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//올라와서 세션가져옴
			HttpSession session = req.getSession();
			//데꺼
			String title = req.getParameter("title");
			String category = req.getParameter("category");
			String content = req.getParameter("content");
			
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			String writerNo = loginMemberVo.getNo();
			//파일은 나중에~
			
			//객체뭉쳐주기
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setCategoryNo(category);
			vo.setContent(content);
			vo.setWriterNo(writerNo);//위로올라가서 세션가져오기
			
			//서비스호출

			BoardService bs = new BoardService();
			int result = bs.insert(vo);
			
			//결과처리
			if(result !=1 ) {
				throw new Exception ("게시글 작성 실패..");
			}
			resp.sendRedirect("/app/board/list");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}

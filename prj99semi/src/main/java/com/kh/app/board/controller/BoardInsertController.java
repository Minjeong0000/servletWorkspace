package com.kh.app.board.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.AttachmentVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.file.FileUpload;

@MultipartConfig(maxFileSize = 1024 * 1024 * 50, // 1024byte*1024byte*50 = 50mb
		maxRequestSize = 1024 * 1024 * 500, //
		fileSizeThreshold = 1024 * 1024 * 50)
@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {

	// 작성화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			BoardService bs = new BoardService();
			List<CategoryVo> categoryVoList = bs.getCategoryVoList();
			req.setAttribute("categoryVoList", categoryVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);

		}

	}

	// 작성하고데이터받기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 올라와서 세션가져옴
			HttpSession session = req.getSession();
			// 데꺼
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String category = req.getParameter("category");
			Collection<Part> parts = req.getParts();
			// 파일여러개받기
			List<Part> fileList = new ArrayList<Part>();
			for (Part part : parts) {
				if (part.getContentType() != null) {
					fileList.add(part);
				}
			}

			//서버에 파일업로드. for문돌리면 attVo객체가 여러개 생김 그걸 넘겨주기 위해 List생성
			List<AttachmentVo>attVoList = new ArrayList<AttachmentVo>();
			for(Part f :fileList) {
				AttachmentVo attVo = FileUpload.saveFile(f);
				attVoList.add(attVo);
			}

			
//			AttachmentVo attVo = null;
			//파일없어도 업로드가능하게끔
//			if(f.getSize()>0) {
//				
//				//서버에 파일 업로드. f에서 스트림 얻어와서 읽고 내보내고 반복
//				//서버에 파일 업로드메소드(util 분리)
//				attVo = FileUpload.saveFile();
//				
//			}

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
			int result = bs.insert(vo,attVoList);
			
	         //디비에 파일 정보(게시글번호,원본파일명,변경된파일명)저장
	         //refNo는 디비에서 다룰거임 시퀀스current로
			
			//결과처리
			if(result < 1) {
				throw new Exception ("게시글 작성 실패..");
			}
			resp.sendRedirect("/app/board/list");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

}

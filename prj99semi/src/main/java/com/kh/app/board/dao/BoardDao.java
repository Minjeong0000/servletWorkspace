package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kh.app.db.JDBCTemplate.*;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.board.vo.PageVo;

public class BoardDao {

	public int insert(Connection conn, BoardVo vo) throws Exception {
		//sql
		String sql = "INSERT INTO BOARD(NO,TITLE,CONTENT,CATEGORY_NO,WRITER_NO)VALUES(SEQ_BOARD.NEXTVAL,?,?,?,?)";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println("dao>vo:::" +vo);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getCategoryNo());
		pstmt.setString(4, vo.getWriterNo());
	
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		return result;
	}

	
	//게시글 목록 조회
	public List<BoardVo> selectBoardList(Connection conn,PageVo pvo) throws Exception {

		//sql
		
		
		String sql ="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM BOARD  B JOIN CATEGORY C ON B.CATEGORY_NO =C.NO JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.DEL_YN ='N' ORDER BY B.NO DESC )T )WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartNum());//가져온 값이 int이므로 setString이 아니라 setInt로
		pstmt.setInt(2, pvo.getEndNum());
		ResultSet rs =pstmt.executeQuery();
		List <BoardVo>voList = new ArrayList<>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String categoryNo = rs.getString("CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String createDate = rs.getString("CREATE_DATE");
			String categoryName = rs.getString("NAME");
			String nick = rs.getString("NICK");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCategoryNo(categoryNo);
			vo.setWriterNo(writerNo);
			vo.setHit(hit);
			vo.setCreateDate(createDate);
			vo.setCategoryName(categoryName);
			vo.setNick(nick);
			
			voList.add(vo);
		}
		close(pstmt);
		close(rs);
		return voList;
	}

	

	public BoardVo getBoardByNo(Connection conn, String no) throws Exception {
		//SQL
		String sql = "SELECT B.NO , B.TITLE , B.CONTENT , B.CATEGORY_NO , C.NAME , B.WRITER_NO , M.NICK , B.HIT , B.CREATE_DATE FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.NO = ? AND B.DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = null;
		if(rs.next()) {
//			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("NAME");
			String writerNo = rs.getString("WRITER_NO");
			String nick = rs.getString("NICK");
			String hit = rs.getString("HIT");
			String createDate = rs.getString("CREATE_DATE");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCategoryNo(categoryNo);
			vo.setWriterNo(writerNo);
			vo.setHit(hit);
			vo.setCreateDate(createDate);
			vo.setCategoryName(categoryName);
			vo.setNick(nick);
		}
		close(rs);
		close(pstmt);
		return vo;
	}//method
	
	
	public int increaseHit(Connection conn , String no) throws Exception {
		
		//SQL
		String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE NO =? AND DEL_YN ='N'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public List<CategoryVo> getCategoryVoList(Connection conn) throws Exception {

		//sql
		String sql = "SELECT * FROM CATEGORY ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<CategoryVo> categoryVoList = new ArrayList<CategoryVo>();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			
			CategoryVo vo = new CategoryVo();
			vo.setNo(no);
			vo.setName(name);
			categoryVoList.add(vo);
			
		}
		close(rs);
		close(pstmt);
		return categoryVoList;
		
	}//method

	public int edit(Connection conn, BoardVo vo) throws Exception {
		//SQL
		String sql = "UPDATE BOARD SET TITLE=?, CONTENT=?, CATEGORY_NO=? WHERE NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getCategoryNo());
		pstmt.setString(4, vo.getNo());
	
		int result = pstmt.executeUpdate();
		close(pstmt);
		return result;
		
	}

	public int delete(Connection conn, BoardVo boardVo) throws Exception {
		//sql
		String sql = "UPDATE BOARD SET DEL_YN = 'Y' WHERE NO= ? AND WRITER_NO= ? AND DEL_YN='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getNo());
		pstmt.setString(2, boardVo.getWriterNo());
		int result = pstmt.executeUpdate();
		close(pstmt);
		return result;

		
		
		
	}

	public int getBoardCnt(Connection conn) throws Exception {
		//sql
		String sql = "SELECT COUNT(NO) FROM BOARD WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		close(rs);
		close(pstmt);
		return cnt;
	
	}

}//class

package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import static com.kh.app.db.JDBCTemplate.*;
public class MemberService {


	private MemberDao dao;
	public MemberService() {
		dao = new MemberDao();
	}
	
	
	//회원가입
	public int join(MemberVo vo) throws Exception {
//		-비지니스로직
		//아이디 유효성 검사
		if(vo.getId().length()<4) {
			throw new Exception("아이디가 너무 짧습니다");
		}
		
		//비밀번호 유효성 검사
		if(vo.getPwd().length()<4) {
			throw new Exception("비밀번호가 너무 짧습니다");
		}
		
		//비밀번호 일치여부 검사
		if(!vo.getPwd().equals(vo.getPwd2())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}		
		
		//닉네임 유효성 검사	
		if(vo.getNick().contains("관리자")) {
			throw new Exception("닉네임에 부적절한 단어가 포함되어 있습니다.");
		}
		
		//dao 호출
		Connection conn = getConnection();
		int result =dao.join(vo,conn);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
			
		}
		close(conn);
		//결과리턴
		return result;
		
	}


	public MemberVo login(MemberVo vo) throws Exception {

		//비즈니스로직 ==서비스로직
		
		//sql(dao호출)
		Connection conn = getConnection();
		MemberVo loginMemberVo = dao.login(conn, vo);
		return loginMemberVo;

	}


	//회원 정보 수정
	public int edit(MemberVo vo) throws Exception {

		//비즈니스로직
		//비밀번호 유효성 검사
		if(!vo.getPwd().equals(vo.getPwd2())) {
			throw new Exception("비밀번호 일치하지 않음");
		}
		if(vo.getPwd().length()<4) {
			throw new Exception("비밀번호가 너무 짧습니다");
		}
		//dao호출
		Connection conn = getConnection();
		int result = dao.edit(conn,vo);
		//트랜잭션처리
		if(result==1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}


	//회원 탈퇴
	public int quit(String no) throws Exception {
		Connection conn = getConnection();
		//dao호출
		int result = dao.quit(conn,no);
		
		if(result ==1) {
			commit(conn);
		}else {
			rollback(conn);
		}close(conn);
		
		return result;
	
	}

	//회원가입
	
	//회원조회(아이디,비번)
	
	
	
	//회원 목록 조회(관리자전용)
	
	//회원 검색(아이디로 ||닉네임으로 검색)(관리자전용)
	
	
	
	
}

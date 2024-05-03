package com.kh.app.member.service;

import static com.kh.app.db.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {

	private MemberDao dao;
	public MemberService() {
		dao = new MemberDao();
	}
	
	public int join(MemberVo vo) throws Exception {
	//비즈니스로직
	//아이디 유효성 검사
	if(vo.getId().length()<4){
		throw new Exception ("아이디가 너무 짧습니다.");
	}
	//비밀번호 일치 검사
	if(!vo.getPwd2().equals(vo.getPwd2())) {
		throw new Exception ("비밀번호가 일치하지 않습니다");
		
	}
	//비밀번호 유효셩
	if(vo.getPwd().length()<4) {
		throw new Exception ("비밀번호가 너무 짧습니다");
	}
	
	//닉네임 유효성 검사
	if(vo.getNick().contains("관리자")) {
		throw new Exception("닉네임에 부적절한 단어가 포함되어 있습니다.");
	}
	
	
	
	Connection conn = getConnection();
	int result = dao.join(vo,conn);
	
	if(result==1) {
		commit(conn);
	}else {
		rollback(conn);
	}
	close(conn);
	
	return result;
	
	}//method
}//class
	
	
	
//
//
//	public MemberVo login() {
//	
//	}
//
//
//
//
//	
//	
//
//}	
//	



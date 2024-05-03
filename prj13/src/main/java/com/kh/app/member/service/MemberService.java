package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	// 복잡한 작업(비즈니스 로직+sql)
	// 비즈니스로직 = 유효성검사
	public int join(MemberVo vo) throws Exception {
		
		//복잡한 작업(비즈니스로직,sql)
		boolean isValid = true;
		if (vo.getMemberId().length() < 4 || vo.getMemberId().length() > 12) {
			isValid = false;
			System.out.println("111");
		}
		if (vo.getMemberPwd().length() < 4 || vo.getMemberPwd().length() > 12) {
			isValid = false;
			System.out.println("222");
		}
		if (!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			isValid = false;
			System.out.println("333");
		}
		if (vo.getMemberNick().contains("관리자") || vo.getMemberNick().contains("운영자")) {
			isValid = false;
		}
		System.out.println("isValid"+isValid);
		
		if(!isValid) {
			return 0;
		}
		System.out.println(vo);
		
		MemberDao dao = new MemberDao();
		int result = dao.join(vo);
		
		return result;
		


	}

	public MemberVo login(MemberVo vo) throws Exception {

		//sql
		MemberDao dao = new MemberDao();
		MemberVo loginMemeberVo = dao.login(vo);
		return loginMemeberVo;
	}
}

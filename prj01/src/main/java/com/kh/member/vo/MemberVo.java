package com.kh.member.vo;

public class MemberVo {

	private String MemberId;
	private String MemberPwd;
	
	public MemberVo(String memberId, String memberPwd) {
		super();
		MemberId = memberId;
		MemberPwd = memberPwd;
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getMemberPwd() {
		return MemberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		MemberPwd = memberPwd;
	}
	@Override
	public String toString() {
		return "MemberVo [MemberId=" + MemberId + ", MemberPwd=" + MemberPwd + "]";
	}
	
	
}

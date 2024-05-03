package com.kh.member;

public class MemberVo {

	public MemberVo(){
		
	}
	
	private String memberId;
	private String memberPwd;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public MemberVo(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}
	@Override
	public String toString() {
		return "MemberoVo [memberId=" + memberId + ", memberPwd=" + memberPwd + "]";
	}
	
	
}

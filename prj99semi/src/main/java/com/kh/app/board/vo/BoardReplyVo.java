package com.kh.app.board.vo;

public class BoardReplyVo {

	private String no;
	private String content;
	private String refNo;
	private String writerNo;
	private String createDate;
	private String delYn;
	private String writerNick;
	//멤버테이블과 조인해서 닉네임도 가져와야함
	//writerNick
	public BoardReplyVo(String no, String content, String refNo, String writerNo, String createDate, String delYn,
			String writerNick) {
		super();
		this.no = no;
		this.content = content;
		this.refNo = refNo;
		this.writerNo = writerNo;
		this.createDate = createDate;
		this.delYn = delYn;
		this.writerNick = writerNick;
	}
	public BoardReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BoardReplyVo [no=" + no + ", content=" + content + ", refNo=" + refNo + ", writerNo=" + writerNo
				+ ", createDate=" + createDate + ", delYn=" + delYn + ", writerNick=" + writerNick + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	
	
	
	
}

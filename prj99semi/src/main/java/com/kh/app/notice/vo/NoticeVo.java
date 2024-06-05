package com.kh.app.notice.vo;

public class NoticeVo {
		private String no;
	   private String title;
	   private String content;
	   private String writerNo;
	   private String hit;
	   private String createDate;
	   private String delYn;
	   private String writerNick;
	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeVo(String no, String title, String content, String writerNo, String hit, String createDate,
			String delYn, String writerNick) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.hit = hit;
		this.createDate = createDate;
		this.delYn = delYn;
		this.writerNick = writerNick;
	}
	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", title=" + title + ", content=" + content + ", writerNo=" + writerNo + ", hit="
				+ hit + ", createDate=" + createDate + ", delYn=" + delYn + ", writerNick=" + writerNick + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
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

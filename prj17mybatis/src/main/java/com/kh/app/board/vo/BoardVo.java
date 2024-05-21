package com.kh.app.board.vo;

public class BoardVo {

	private String content;
	private String title;
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(String content, String title) {
		super();
		this.content = content;
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BoardVo [content=" + content + ", title=" + title + "]";
	}
	
	
}

package com.kh.app.board.vo;

public class SearchVo {

	private String type;
	private String value;
	public SearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchVo(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	@Override
	public String toString() {
		return "SearchVo [type=" + type + ", value=" + value + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}

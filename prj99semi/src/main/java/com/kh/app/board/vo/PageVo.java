package com.kh.app.board.vo;

public class PageVo {
//getter, 생성자,to string만 만들기
	
	//외부에서받아올데이터
	private int listCount;		//총 개시글 갯수=>db가서 조회count
	private int currentPage;	//현재 페이지 =>화면에서 받아옴
	private int pageLimit;	//페이징바 페이지 최대 갯수 =>외부에서받아옴?
	private int boardLimit;	//한 페이지에 보여줄 게시글 갯수
	
	
	
	//위 변수 사용해서 계산해야함
	private int maxPage;		//마지막 페이지
	private int startPage;		//페이징바 시작
	private int endPage;		//페이징바 마지막
	private int startNum;		//조회할 rownum 시작
	private int endNum;			//조회할 rownum 마지막
	
	public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		
		//총게시글개수/한페이지에 보여줄 페이지갯수 ->인트와 인트끼리의 계산식이므로 더블타입으로 형변환 후 올림
		this.maxPage = (int)Math.ceil((double)listCount/boardLimit); 
		this.startPage = (currentPage-1)/pageLimit*pageLimit+1;
		this.endPage = startPage+pageLimit-1;
		if(endPage>maxPage) {//끝번호는 전체페이지보다 많을 수 없음
			endPage = maxPage;
		}
		this.startNum = (currentPage-1)*boardLimit+1;
		this.endNum = startNum+boardLimit-1;
		
	}//constructor

	public int getListCount() {
		return listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	
	//값 잘 들어왔는지 확인용
	@Override
	public String toString() {
		return "PageVo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", startNum=" + startNum + ", endNum=" + endNum + "]";
	}

	
	
	
	
}//class

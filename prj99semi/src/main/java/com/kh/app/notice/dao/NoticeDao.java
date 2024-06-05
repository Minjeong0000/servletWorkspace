package com.kh.app.notice.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.PageVo;
import com.kh.app.notice.vo.NoticeVo;

public class NoticeDao {

	//작성
	public int write(SqlSession ss, NoticeVo vo ) {
		return ss.insert("NoticeMapper.write",vo);
	}
	
	//목록조회
	public List<NoticeVo> getNoticeList(SqlSession ss,PageVo pvo){
		//rowbounds 객체 생성. offset=건너뛸행갯수 limit = 
		
		int offset =pvo.getStartNum()-1;
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset,limit);
		return ss.selectList("NoticeMapper.getNoticeList",null,rb);
		
	}
	
	//상세조회
	public NoticeVo getNotice(SqlSession ss,  String no) {
		return ss.selectOne("NoticeMapper.getNotice",no);
	}
	//공지사항 갯수 조회
	public int getNoticeCount(SqlSession ss) {
		return ss.selectOne("NoticeMapper.getCnt");
	}
	
	
}

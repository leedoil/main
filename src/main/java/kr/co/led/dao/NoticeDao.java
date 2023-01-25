package kr.co.led.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.NoticeBean;
import kr.co.led.mapper.NoticeMapper;

@Repository
public class NoticeDao {

	@Autowired
	private NoticeMapper noticeMapper;

	// 글작성
	public void addNoticeInfo(NoticeBean writeNoticeBean) {
		noticeMapper.addNoticeInfo(writeNoticeBean);
	}

	// 글 목록보기
	public List<NoticeBean> getNoticeList(String notice_type, RowBounds rowBounds) {
		return noticeMapper.getNoticeList(notice_type, rowBounds);
	}

	// 글 하나보기
	public NoticeBean getNoticeInfo(int notice_idx) {
		return noticeMapper.getNoticeInfo(notice_idx);
	}

	// 게시물 수정하기
	public void modifyNoticeInfo(NoticeBean modifyNoticeBean) {
		noticeMapper.modifyNoticeInfo(modifyNoticeBean);
	}

	// 게시물 삭제
	public void deleteNoticeInfo(int notice_idx) {
		noticeMapper.deleteNoticeInfo(notice_idx);
	}

	// 전체 게시물 개수
	public int getNoticeCnt(String notice_type) {
		return noticeMapper.getNoticeCnt(notice_type);
	}

}
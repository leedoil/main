package kr.co.led.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.QuestionBean;
import kr.co.led.mapper.QuestionMapper;

@Repository
public class QuestionDao {
	
	@Autowired
	private QuestionMapper questionMapper;

	public void addQuestionInfo(QuestionBean writeQuestionBean) {
		
		 questionMapper.addQuestionInfo(writeQuestionBean);
	}
	
	
	// 게시글 모두 가져오기
	public List<QuestionBean> getQuestionList(int user_idx, RowBounds rowBounds){
		return questionMapper.getQuestionList(user_idx, rowBounds);
	}
	
	//게시글 하나 가져오기
	public QuestionBean getQuestionInfo(int question_idx) {
		return questionMapper.getQuestionInfo(question_idx);
	}
	
	//수정
	public void modifyQuestionInfo(QuestionBean modifyQuestionBean) {
		questionMapper.modifyQuestionInfo(modifyQuestionBean);
	}
	
	//삭제
	public void deleteQuestionInfo(int question_idx) {
		questionMapper.deleteQuestionInfo(question_idx);
	}
	
	//카운트 나누기?
	public int getQuestionCnt(int question_idx) {
		return questionMapper.getQuestionCnt(question_idx);
	}
}

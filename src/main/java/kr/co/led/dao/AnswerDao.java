package kr.co.led.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.AnswerBean;
import kr.co.led.mapper.AnswerMapper;

@Repository
public class AnswerDao {

	@Autowired
	private AnswerMapper answerMapper;
	
	public void addAnswerInfo(AnswerBean writeAnswerBean) {
		
		answerMapper.addAnswerInfo(writeAnswerBean);
	}
	
	
	
	
	//답글 모두 가져오기
	public List<AnswerBean> getanswerList() {
		
		return answerMapper.getanswerList();
	}
	
	
	
	//답글 필요한거만 가져오기
	public AnswerBean getAnswerInfo(int question_idx) {
		
		return answerMapper.getAnswerInfo(question_idx);
	}
	
	//수정
	public void modifyAnswerInfo(AnswerBean modifyAnswerBean) {
		
		answerMapper.modifyAnswerInfo(modifyAnswerBean);	
	}
	
	//삭제
	public void deleteAnswerInfo(int answer_idx) {
		
		answerMapper.deleteAnswerInco(answer_idx);
	}
	
	
	
}

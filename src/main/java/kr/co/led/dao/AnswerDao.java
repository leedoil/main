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
	
	
	
	
	//��� ��� ��������
	public List<AnswerBean> getanswerList() {
		
		return answerMapper.getanswerList();
	}
	
	
	
	//��� �ʿ��ѰŸ� ��������
	public AnswerBean getAnswerInfo(int question_idx) {
		
		return answerMapper.getAnswerInfo(question_idx);
	}
	
	//����
	public void modifyAnswerInfo(AnswerBean modifyAnswerBean) {
		
		answerMapper.modifyAnswerInfo(modifyAnswerBean);	
	}
	
	//����
	public void deleteAnswerInfo(int answer_idx) {
		
		answerMapper.deleteAnswerInco(answer_idx);
	}
	
	
	
}

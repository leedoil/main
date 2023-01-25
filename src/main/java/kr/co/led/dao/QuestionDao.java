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
	
	
	// �Խñ� ��� ��������
	public List<QuestionBean> getQuestionList(int user_idx, RowBounds rowBounds){
		return questionMapper.getQuestionList(user_idx, rowBounds);
	}
	
	//�Խñ� �ϳ� ��������
	public QuestionBean getQuestionInfo(int question_idx) {
		return questionMapper.getQuestionInfo(question_idx);
	}
	
	//����
	public void modifyQuestionInfo(QuestionBean modifyQuestionBean) {
		questionMapper.modifyQuestionInfo(modifyQuestionBean);
	}
	
	//����
	public void deleteQuestionInfo(int question_idx) {
		questionMapper.deleteQuestionInfo(question_idx);
	}
	
	//ī��Ʈ ������?
	public int getQuestionCnt(int question_idx) {
		return questionMapper.getQuestionCnt(question_idx);
	}
}

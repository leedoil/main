package kr.co.led.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.co.led.beans.AnswerBean;
import kr.co.led.beans.UserBean;
import kr.co.led.dao.AnswerDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class AnswerService {
	
	@Autowired
	private AnswerDao answerDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;  
	
    
    public void addAnswerInfo(AnswerBean writeAnswerBean) {
    	
    	writeAnswerBean.setAdmin_id(loginUserBean.getUser_id());
    	
    	answerDao.addAnswerInfo(writeAnswerBean);
    }
    
   
    
	
	public List<AnswerBean> answerlist() {
		List<AnswerBean> answerlist = answerDao.getanswerList();
		return answerlist;
	}
	
	
	
	
	public AnswerBean getAnswerInfo(int question_idx) {
		return answerDao.getAnswerInfo(question_idx);
	}
	
	//수정
	public void modifyAnswerInfo(AnswerBean modifyAnswerBean) {
		answerDao.modifyAnswerInfo(modifyAnswerBean);
	}
	
	//삭제
	public void deleteAnswerInfo(int answer_idx) {
		answerDao.deleteAnswerInfo(answer_idx);
	}
	
	

}

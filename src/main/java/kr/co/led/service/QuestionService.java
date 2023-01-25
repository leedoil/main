package kr.co.led.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.led.beans.PageBean;
import kr.co.led.beans.QuestionBean;
import kr.co.led.beans.UserBean;
import kr.co.led.dao.QuestionDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;  
	
	@Value("${path.upload}")
	private String path_upload;
	
	@Value("${page.listcnt}")
	private int page_listcnt;

    @Value("${page.paginationcnt}")
    private int page_paginationcnt;
	
	
	   
	   public void addQuestionInfo(QuestionBean writeQuestionBean) {
	      
	      //System.out.println(writeQuestionBean.getQuestion_title());
	      //System.out.println(writeQuestionBean.getQuestion_content());
	      //System.out.println(writeQuestionBean.getUpload_file().getSize());
	      
	      
	      writeQuestionBean.setUser_idx(loginUserBean.getUser_idx());
	      
	      questionDao.addQuestionInfo(writeQuestionBean);
	      
	   }
	   
	  //페이지 당 번호
	   public List<QuestionBean> getQuestionList(int user_idx , int page){
		   int start = (page -1) * page_listcnt;
		   RowBounds rowBounds = new RowBounds(start, page_listcnt);
		   
		   return questionDao.getQuestionList(user_idx, rowBounds);
	   }
	   
	   
	   public QuestionBean getQuestionInfo(int question_idx) {
		   return questionDao.getQuestionInfo(question_idx);
	   }
	   
	   public void modifyQuestionInfo(QuestionBean modifyQuestionBean) {
		  
	 		questionDao.modifyQuestionInfo(modifyQuestionBean);
	   }
	   
	   public void deleteQuestionInfo(int question_idx) {
		   questionDao.deleteQuestionInfo(question_idx);
	   }
	   
	   //카운트
	   public PageBean getQuestionCnt(int question_idx, int currentPage) {
		   int question_cnt = questionDao.getQuestionCnt(question_idx);
		   
		   PageBean pageBean = new PageBean(question_cnt, currentPage, page_listcnt, page_paginationcnt);
		   
		   return pageBean;
		   
	   }
	   
	   
	   
	   
	   
	   

	}
	


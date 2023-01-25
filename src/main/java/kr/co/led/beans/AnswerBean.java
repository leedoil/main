package kr.co.led.beans;

import javax.validation.constraints.NotBlank;

public class AnswerBean {

	private int answer_idx; 
	private int question_idx; 
	
	@NotBlank
	private String answer_content; 
	private String admin_id;
	
	
	public int getAnswer_idx() {
		return answer_idx;
	}
	public void setAnswer_idx(int answer_idx) {
		this.answer_idx = answer_idx;
	}
	public int getQuestion_idx() {
		return question_idx;
	}
	public void setQuestion_idx(int question_idx) {
		this.question_idx = question_idx;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	} 
	
	
	
	
	
	
	
}

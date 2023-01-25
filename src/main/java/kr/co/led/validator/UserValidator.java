package kr.co.led.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.led.beans.UserBean;
//사용자가 추가하는 유효성 검사 클래스
public class UserValidator implements Validator{

	//유효성 검사할 클래스 지정
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.isAssignableFrom(clazz);
	}

	//유효성 검사 구현부
	@Override
	public void validate(Object target, Errors errors) {
		
		UserBean postUserBean=(UserBean) target;
		
		String beanName=errors.getObjectName();
		//System.out.println(beanName);
		
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
		
		if(postUserBean.getUser_pw().equals(postUserBean.getUser_pw2()) == false) {
			errors.rejectValue("user_pw", "NotEquals");
			errors.rejectValue("user_pw2", "NotEquals");
		}
	}
		if(beanName.equals("joinUserBean")) {
		if(postUserBean.isUserIdExist() == false) {
			errors.rejectValue("user_id", "DontCheckUserIdExist");
			errors.rejectValue("agree", "DontCheckUserIdExist");
		}
		if(postUserBean.isUserEmailExist() == false) {
			errors.rejectValue("user_email", "DontCheckUserEmailExist");
		}
	  }//out if
	}
}


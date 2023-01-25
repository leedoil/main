package kr.co.led.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.led.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	//로그인 여부를 판단하는 loginUserBean
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		
		this.loginUserBean=loginUserBean;
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(loginUserBean.isUserLogin() == false) {
			//로그인을 하지 않은 상태에서의 경로 추출
			String contextPath=request.getContextPath();
			//로그인이 되지 않았으므로 웹브라우저에게 not_login을 요청하라고 구현
			response.sendRedirect(contextPath + "/not_login");
			//다음 단계로 이동하지 않음
			return false;
		}
		
		return true;
	}

}

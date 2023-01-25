package kr.co.led.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.led.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	//�α��� ���θ� �Ǵ��ϴ� loginUserBean
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		
		this.loginUserBean=loginUserBean;
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(loginUserBean.isUserLogin() == false) {
			//�α����� ���� ���� ���¿����� ��� ����
			String contextPath=request.getContextPath();
			//�α����� ���� �ʾ����Ƿ� ������������ not_login�� ��û�϶�� ����
			response.sendRedirect(contextPath + "/not_login");
			//���� �ܰ�� �̵����� ����
			return false;
		}
		
		return true;
	}

}

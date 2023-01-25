package kr.co.led.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.led.beans.UserBean;

public class TopMenuInterceptor implements HandlerInterceptor{
   
   @Autowired
   private UserBean loginUserBean;
   
   public TopMenuInterceptor(UserBean loginUserBean) {
      
      this.loginUserBean = loginUserBean;
   }

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {

      request.setAttribute("loginUserBean", loginUserBean);
      
      return true;
   }

   
   
}
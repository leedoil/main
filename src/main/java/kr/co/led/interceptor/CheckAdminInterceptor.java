package kr.co.led.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.led.beans.UserBean;

public class CheckAdminInterceptor implements HandlerInterceptor {

   
   private UserBean adminBean;
   
   public CheckAdminInterceptor(UserBean adminBean) {
      
      this.adminBean = adminBean;
   }

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {

      if(adminBean.isAdminLogin() == false) {
         
         String contextPath = request.getContextPath();
         
         response.sendRedirect(contextPath + "/not_admin");
         
         return false;
      }
      
      return true;
   }
}
package kr.co.led.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.led.beans.UserBean;
import kr.co.led.dao.UserDao;

@Service
public class UserService {

   @Autowired
   private UserDao userDao; // DAO안에 데이터베이스 주입

   @Resource(name = "loginUserBean")
   private UserBean loginUserBean;

   // 요청한 아이디가 사용 가능한지 여부를 판단
   public boolean checkUserIdExist(String user_id) {

      String user_name = userDao.checkUserIdExist(user_id);

      if (user_name == null) {
         return true;
      } else {
         return false;
      }

   }

   public boolean checkUserEmailExist(String user_email) {

      String user_name = userDao.checkUserEmailExist(user_email);

      if (user_name == null) {
         return true;
      } else {
         return false;
      }

   }

   public void addUserInfo(UserBean joinUserBean) {

      userDao.addUserInfo(joinUserBean);
   }

   public void getLoginUserInfo(UserBean tempLoginUserBean) {

      UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
      // 가져온 데이터가 있다면
      if (tempLoginUserBean2 != null) {
         loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
         loginUserBean.setUser_id(tempLoginUserBean2.getUser_id());
         loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
         loginUserBean.setUser_pw(tempLoginUserBean2.getUser_pw());
         loginUserBean.setUser_pw2(tempLoginUserBean2.getUser_pw2());
         loginUserBean.setUser_grade(tempLoginUserBean2.getUser_grade());
         loginUserBean.setUser_phone(tempLoginUserBean2.getUser_phone());
         loginUserBean.setUser_email(tempLoginUserBean2.getUser_email());
         loginUserBean.setSample6_postcode(tempLoginUserBean2.getSample6_postcode());
         loginUserBean.setSample6_address(tempLoginUserBean2.getSample6_address());
         loginUserBean.setSample6_detailAddress(tempLoginUserBean2.getSample6_detailAddress());
         loginUserBean.setSample6_extraAddress(tempLoginUserBean2.getSample6_extraAddress());
         loginUserBean.setUserLogin(true);
      }
   }

   public void getModifyUserInfo(UserBean modifyUserBean) {
      // 로그인한 회원의 정보 가져오기
      UserBean tempModifyUserBean2 = userDao.getModifyUserInfo(loginUserBean.getUser_idx());

      modifyUserBean.setUser_idx(tempModifyUserBean2.getUser_idx());
      modifyUserBean.setUser_id(tempModifyUserBean2.getUser_id());
      modifyUserBean.setUser_name(tempModifyUserBean2.getUser_name());
      modifyUserBean.setUser_email(tempModifyUserBean2.getUser_email());
      modifyUserBean.setUser_phone(tempModifyUserBean2.getUser_phone());
      modifyUserBean.setUser_grade(tempModifyUserBean2.getUser_grade());
      modifyUserBean.setSample6_address(tempModifyUserBean2.getSample6_address());
      modifyUserBean.setSample6_postcode(tempModifyUserBean2.getSample6_postcode());
      modifyUserBean.setSample6_detailAddress(tempModifyUserBean2.getSample6_detailAddress());
      modifyUserBean.setSample6_extraAddress(tempModifyUserBean2.getSample6_extraAddress());

      modifyUserBean.setUser_idx(loginUserBean.getUser_idx());

   }

   public void modifyUserInfo(UserBean modifyUserBean) {

      modifyUserBean.setUser_idx(loginUserBean.getUser_idx());

      userDao.modifyUserInfo(modifyUserBean);

   }

   public void deleteUserInfo(int user_idx) {

      userDao.deleteUserInfo(user_idx);
   }

}
package kr.co.led.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.UserBean;
import kr.co.led.mapper.UserMapper;

@Repository
public class UserDao {
   
   @Autowired
   private UserMapper userMapper;
   
   public String checkUserIdExist(String user_id) {
      return userMapper.checkUserIdExist(user_id); //sql        
   }
   
   public String checkUserEmailExist(String user_email) {
         return userMapper.checkUserEmailExist(user_email);  
      }
   
   public void addUserInfo(UserBean joinUserBean) {
      
      userMapper.addUserInfo(joinUserBean);
   }
   
   public UserBean getLoginUserInfo(UserBean tempLoginUserBean) {
      return userMapper.getLoginUserInfo(tempLoginUserBean);
   }
   
   public UserBean getModifyUserInfo(int user_idx) {
      return userMapper.getModifyUserInfo(user_idx);
   }
   
   public void modifyUserInfo(UserBean modifyUserBean) {
      userMapper.modifyUserInfo(modifyUserBean);
   }
    
    public void deleteUserInfo(int user_idx) {
       userMapper.deleteUserInfo(user_idx);
    }
    public UserBean getDeleteUserInfo(int user_idx) {
       return userMapper.getDeleteUserInfo(user_idx);
    }
}
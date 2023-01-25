package kr.co.led.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.led.beans.UserBean;

public interface UserMapper {
   
   @Select("select user_name "+
               "from user_table "+
               "where user_id=#{user_id}")
   String checkUserIdExist(String user_id);
   
   @Select("select user_email "+
           "from user_table "+
           "where user_email=#{user_email}")
   String checkUserEmailExist(String user_email);
   
   @Insert("insert into user_table(user_idx, user_name, user_id, user_pw, user_pw2, user_grade, user_gender, user_phone, user_email, sample6_postcode, sample6_address, sample6_detailAddress, sample6_extraAddress) "+
            "values(user_seq.nextval, #{user_name}, #{user_id}, #{user_pw}, #{user_pw2}, 'silver', #{user_gender}, #{user_phone}, #{user_email}, #{sample6_postcode}, #{sample6_address}, #{sample6_detailAddress}, #{sample6_extraAddress})")
      void addUserInfo(UserBean joinUserBean);
   
   @Select("select * "
         + "from user_table "
         + "where user_id=#{user_id} and user_pw=#{user_pw}")           
   UserBean getLoginUserInfo(UserBean tempLoginUserBean);
   
   @Select("select user_id, user_pw, user_name, user_grade, user_phone, user_email, sample6_postcode, sample6_address, sample6_detailAddress, sample6_extraAddress "+
         "from user_table " + 
         "where user_idx = #{user_idx}")
   UserBean getModifyUserInfo(int user_idx);
   
   
   @Update("update user_table "
         + "set user_pw=#{user_pw}, user_pw2=#{user_pw2}, user_phone=#{user_phone}, user_email=#{user_email}, sample6_postcode=#{sample6_postcode}, sample6_address=#{sample6_address}, sample6_detailAddress=#{sample6_detailAddress}, sample6_extraAddress=#{sample6_extraAddress} "
         + "where user_idx=#{user_idx}")
   void modifyUserInfo(UserBean modifyUserBean);
   
   @Delete("delete from user_table where user_idx=#{user_idx}")
   void deleteUserInfo(int user_idx);

   @Select("select user_idx from user_table where user_idx=#{user_idx}")
   UserBean getDeleteUserInfo(int user_idx);
   

}
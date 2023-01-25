package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.led.beans.ProductBean;
import kr.co.led.beans.QuestionBean;
import kr.co.led.beans.UserBean;

public interface AdminMapper {

   
   //��ü���� ����Ʈ
   @Select("select * "
         + "from user_table "
         + "where user_idx != 1")
   List<UserBean> getUserList();
   
   //�������� ����
   @Update("update user_table "
         + "set user_grade = #{user_grade} "
         + "where user_idx = #{user_idx}")
   void modifyUserInfo(UserBean adminModifyBean);
   
   //��ǰ ��ü ����Ʈ
   @Select("select * "
          + "from product")
   List<ProductBean> getAllProductList();
   
   //ī��Ʈ
   @Select("select count(*) from user_table")
   int getUserCnt();
   
   @Select("select count(*) from product")
   int getProductCnt();
   
   @Update("update product "
	         + "set product_price = #{product_price} "
	         + "where product_idx = #{product_idx}")
   void modifyProductPrice(ProductBean modifyPriceBean);
   
   @Update("update product "
		   + "set product_instock = #{product_instock} "
		   + "where product_idx = #{product_idx}")
   void modifyProductStock(ProductBean modifyStockBean);
  
   //=============================================
   
   //1��1���� ��ü �������
   @Select("select question_idx, question_title, ut.user_name as user_name, to_char(question_date, 'yyyy-mm-dd') as question_date "
   		+ "from question qt, user_table ut "
   		+ "where qt.user_idx = ut.user_idx "
   		+ "order by question_idx desc")
   List<QuestionBean> getAllQuestion();
}
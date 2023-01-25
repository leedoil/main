package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.led.beans.CartBean;
import kr.co.led.beans.CartListBean;

public interface CartMapper {
   
   //같은 제품 있는지 확인
   @Select("select count(*) from cart "
         + "where user_idx = #{user_idx} and product_idx = #{product_idx}")
   int checkCart(CartBean cartBean);
   
   //상품 수량 업데이트 
   @Update("update cart set product_amount = (product_amount + #{product_amount}) "
         + "where user_idx = #{user_idx} and product_idx = #{product_idx}")
   void updateCart(CartBean cartBean);
   
   //상품 수량 업데이트 장바구니에서 
   @Update("update cart set product_amount = #{product_amount} "
         + "where user_idx = #{user_idx} and product_idx = #{product_idx}")
   void changeCnt(CartBean cartBean);
   
   //카트 추가
   @Insert("insert into cart(user_idx, product_idx, product_amount) "
         + "values(#{user_idx}, #{product_idx}, #{product_amount})")
   void addCart(CartBean cartBean);
   
   //카트에 담긴 상품 수량 총 갯수 
   @Select("select sum(product_idx) from cart where user_idx = #{user_idx}")
   Integer countCart(int user_idx);
   
   //카트 목록
   @Select("select c.product_idx, product_name, product_price, product_img1, product_amount, (product_price*product_amount) as subtotal "
         + "from cart c "
         + "join product p "
         + "on c.product_idx = p.product_idx "
         + "where user_idx = #{user_idx} "
         + "group by c.product_idx, product_name, product_price, product_img1, product_amount")
   List<CartListBean> cartList(int user_idx);
   
   //카트 전체 삭제
   @Delete("delete from cart where user_idx = #{user_idx}")
   void deleteCartAll(int user_idx);
   
   //선택한 상품 삭제
   @Delete("delete from cart where user_idx = #{user_idx} and product_idx = #{product_idx}")
   void deleteCartSelected(CartBean cartBean);
   
}
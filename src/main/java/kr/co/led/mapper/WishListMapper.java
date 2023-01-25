package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import kr.co.led.beans.WishListBean;

public interface WishListMapper {

     //같은 제품 있는지 확인
      @Select("select count(*) from wishList "
            + "where user_idx = #{user_idx} and product_idx = #{product_idx}")
      int checkWishList(WishListBean wishListBean);
   
    //추가
      @Insert("insert into wishlist(user_idx, product_idx) "
            + "values(#{user_idx}, #{product_idx})")
      void addWishList(WishListBean wishListBean);
      
      //카트에 담긴 상품 수량 총 갯수 
      @Select("select sum(product_idx) from wishList where user_idx = #{user_idx}")
      Integer countWishList(int user_idx);
      
      
      // 목록
      @Select("select w.product_idx, p.product_name, p.product_price, p.product_img1, p.product_instock "
            + "from wishlist w "
            + "join product p "
            + "on w.product_idx = p.product_idx "
            + "where w.user_idx = #{user_idx} "
            + "group by w.product_idx, p.product_name, p.product_price, p.product_img1, p.product_instock")
      List<WishListBean> wishList(int user_idx);
      
      //전체 삭제
      @Delete("delete from wishList where user_idx = #{user_idx}")
      void deleteWishListAll(int user_idx);
      
      //선택한 상품 삭제
      @Delete("delete from wishlist where user_idx = #{user_idx} and product_idx = #{product_idx}")
      void deleteWishListSelected(WishListBean wishListBean);
   
}
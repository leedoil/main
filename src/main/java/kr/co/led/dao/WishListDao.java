package kr.co.led.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.WishListBean;
import kr.co.led.mapper.WishListMapper;

@Repository
public class WishListDao {

   @Autowired
   private WishListMapper wishListMapper;
   
   public int checkWishList(WishListBean wishListBean) {
      return wishListMapper.checkWishList(wishListBean);
   }
   
    public void addWishList(WishListBean wishListBean) {
       wishListMapper.addWishList(wishListBean);
    }
    
    public Integer countWishList(int user_idx) {
     return wishListMapper.countWishList(user_idx);
    }
    public List<WishListBean> wishList(int user_idx){
     return wishListMapper.wishList(user_idx);
    }
    
     public void deleteWishListAll(int user_idx) {
      wishListMapper.deleteWishListAll(user_idx);  
     }
     
      public void deleteWishListSelected(WishListBean wishListBean) {
        wishListMapper.deleteWishListSelected(wishListBean);
      }
}
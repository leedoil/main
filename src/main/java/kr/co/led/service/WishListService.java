package kr.co.led.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.led.beans.WishListBean;
import kr.co.led.dao.WishListDao;


@Service
public class WishListService {

   @Autowired
   private WishListDao wishListDao;
   
     public int checkWishList(WishListBean wishListBean) {
        return wishListDao.checkWishList(wishListBean);
     }
   
    public void addWishList(WishListBean wishListBean) {
       wishListDao.addWishList(wishListBean);
    }
    
    public Integer countWishList(int user_idx) {
        return wishListDao.countWishList(user_idx);
    }
     
    public List<WishListBean> wishList(int user_idx){
     return wishListDao.wishList(user_idx);
    }
    
     public void deleteWishListAll(int user_idx) {
      wishListDao.deleteWishListAll(user_idx);  
     }
     
     public void deleteWishListSelected(WishListBean wishListBean) {
       wishListDao.deleteWishListSelected(wishListBean); 
       }
    
}
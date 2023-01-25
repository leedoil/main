package kr.co.led.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.led.beans.CartBean;
import kr.co.led.beans.CartListBean;
import kr.co.led.dao.CartDao;

@Service
public class CartService {
   
   @Autowired
   private CartDao cartDao;
   
   public int checkCart(CartBean cartBean) {
      return cartDao.checkCart(cartBean);
   }
   
   public void updateCart(CartBean cartBean) {
      cartDao.updateCart(cartBean);
   }
   
   public void changeCnt(CartBean cartBean) {
      cartDao.changeCnt(cartBean);
   }
   
   public void addCart(CartBean cartBean) {
      cartDao.addCart(cartBean);
   }
   
   public Integer countCart(int user_idx) {
      return cartDao.countCart(user_idx);
   }
   
   public List<CartListBean> cartList(int user_idx) {
      return cartDao.cartList(user_idx);
   }
   
   public void deleteCartAll(int user_idx) {
      cartDao.deleteCartAll(user_idx);
   }
   
   public void deleteCartSelected(CartBean cartBean) {
      cartDao.deleteCartSelected(cartBean);
   }
   
}
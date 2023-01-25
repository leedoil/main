package kr.co.led.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.CartBean;
import kr.co.led.beans.CartListBean;
import kr.co.led.mapper.CartMapper;

@Repository
public class CartDao {
   
   @Autowired
   private CartMapper cartMapper;
   
   public int checkCart(CartBean cartBean) {
      return cartMapper.checkCart(cartBean);
   }
   
   public void updateCart(CartBean cartBean) {
      cartMapper.updateCart(cartBean);
   }
   
   public void changeCnt(CartBean cartBean) {
      cartMapper.changeCnt(cartBean);
   }
   
   public void addCart(CartBean cartBean) {
      cartMapper.addCart(cartBean);
   }
   
   public Integer countCart(int user_idx) {
      return cartMapper.countCart(user_idx);
   }
   
   public List<CartListBean> cartList(int user_idx) {
      return cartMapper.cartList(user_idx);
   }
   
   public void deleteCartAll(int user_idx) {
      cartMapper.deleteCartAll(user_idx);
   }
   
   public void deleteCartSelected(CartBean cartBean) {
      cartMapper.deleteCartSelected(cartBean);
   }
   
}
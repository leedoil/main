package kr.co.led.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartBean {
   
   private int user_idx;
   private int product_idx;
   private int product_amount;
public int getUser_idx() {
	return user_idx;
}
public void setUser_idx(int user_idx) {
	this.user_idx = user_idx;
}
public int getProduct_idx() {
	return product_idx;
}
public void setProduct_idx(int product_idx) {
	this.product_idx = product_idx;
}
public int getProduct_amount() {
	return product_amount;
}
public void setProduct_amount(int product_amount) {
	this.product_amount = product_amount;
}
   
   
}
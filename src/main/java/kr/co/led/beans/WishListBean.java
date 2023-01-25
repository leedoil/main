package kr.co.led.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WishListBean {

   private int user_idx;
   private int product_idx;
   private int product_instock;
   private String product_name;
   private String product_price;
   private String stock_status;
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
public int getProduct_instock() {
	return product_instock;
}
public void setProduct_instock(int product_instock) {
	this.product_instock = product_instock;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_price() {
	return product_price;
}
public void setProduct_price(String product_price) {
	this.product_price = product_price;
}
public String getStock_status() {
	return stock_status;
}
public void setStock_status(String stock_status) {
	this.stock_status = stock_status;
}
   
   
}
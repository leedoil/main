package kr.co.led.beans;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartListBean {
   
   private int product_idx;
   private String product_name;
   private int product_price;
   private String product_img1;
   private int product_amount;
   private int subtotal;
   
   private List<CartBean> cartList;

public int getProduct_idx() {
	return product_idx;
}

public void setProduct_idx(int product_idx) {
	this.product_idx = product_idx;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public int getProduct_price() {
	return product_price;
}

public void setProduct_price(int product_price) {
	this.product_price = product_price;
}

public String getProduct_img1() {
	return product_img1;
}

public void setProduct_img1(String product_img1) {
	this.product_img1 = product_img1;
}

public int getProduct_amount() {
	return product_amount;
}

public void setProduct_amount(int product_amount) {
	this.product_amount = product_amount;
}

public int getSubtotal() {
	return subtotal;
}

public void setSubtotal(int subtotal) {
	this.subtotal = subtotal;
}

public List<CartBean> getCartList() {
	return cartList;
}

public void setCartList(List<CartBean> cartList) {
	this.cartList = cartList;
}
   
   
}
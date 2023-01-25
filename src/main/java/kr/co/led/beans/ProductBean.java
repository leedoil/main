package kr.co.led.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBean {
   
   private int product_idx;
   private String product_name;
   private int product_price;
   private String product_gender;
   private String product_colortype;
   private String product_img1;
   private String product_img2;
   private int product_instock;
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
public String getProduct_gender() {
	return product_gender;
}
public void setProduct_gender(String product_gender) {
	this.product_gender = product_gender;
}
public String getProduct_colortype() {
	return product_colortype;
}
public void setProduct_colortype(String product_colortype) {
	this.product_colortype = product_colortype;
}
public String getProduct_img1() {
	return product_img1;
}
public void setProduct_img1(String product_img1) {
	this.product_img1 = product_img1;
}
public String getProduct_img2() {
	return product_img2;
}
public void setProduct_img2(String product_img2) {
	this.product_img2 = product_img2;
}
public int getProduct_instock() {
	return product_instock;
}
public void setProduct_instock(int product_instock) {
	this.product_instock = product_instock;
}
   
   
}
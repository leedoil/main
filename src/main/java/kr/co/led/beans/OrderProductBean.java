package kr.co.led.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductBean {

   private int order_idx;
   private int product_idx;
   private int order_product_amount;
   private int order_prosubtotal;
public int getOrder_idx() {
	return order_idx;
}
public void setOrder_idx(int order_idx) {
	this.order_idx = order_idx;
}
public int getProduct_idx() {
	return product_idx;
}
public void setProduct_idx(int product_idx) {
	this.product_idx = product_idx;
}
public int getOrder_product_amount() {
	return order_product_amount;
}
public void setOrder_product_amount(int order_product_amount) {
	this.order_product_amount = order_product_amount;
}
public int getOrder_prosubtotal() {
	return order_prosubtotal;
}
public void setOrder_prosubtotal(int order_prosubtotal) {
	this.order_prosubtotal = order_prosubtotal;
}
   
   
}
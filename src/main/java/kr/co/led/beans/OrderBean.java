package kr.co.led.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBean {
	
	private int user_idx;
	private int order_idx;
	private String order_date;
	private String order_method;
	private String odrer_company;
	private String order_number;
	private String order_amount;
	private String order_sum;
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getOrder_idx() {
		return order_idx;
	}
	public void setOrder_idx(int order_idx) {
		this.order_idx = order_idx;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_method() {
		return order_method;
	}
	public void setOrder_method(String order_method) {
		this.order_method = order_method;
	}
	public String getOdrer_company() {
		return odrer_company;
	}
	public void setOdrer_company(String odrer_company) {
		this.odrer_company = odrer_company;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public String getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(String order_amount) {
		this.order_amount = order_amount;
	}
	public String getOrder_sum() {
		return order_sum;
	}
	public void setOrder_sum(String order_sum) {
		this.order_sum = order_sum;
	}
	
	
}

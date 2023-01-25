package kr.co.led.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserBean {
	
	@Size(min = 2, max = 4)
	@Pattern(regexp = "[가-힣]*")
	private String user_name;

	private int user_idx;
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_id;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw2;

	private String user_grade;
	private String user_phone;
	private String user_gender;
	private String user_email;
	private String sample6_postcode;
	private String sample6_address;
	private String sample6_detailAddress;
	private String sample6_extraAddress;

	private String agree;
	
	private boolean userIdExist;
	
	private boolean userEmailExist;

	private boolean userLogin;
	
	private boolean adminLogin;

	
	
	public boolean isAdminLogin() {
		return adminLogin;
	}

	public void setAdminLogin(boolean adminLogin) {
		this.adminLogin = adminLogin;
	}

	public UserBean() {
		this.userIdExist = false;
		this.userEmailExist = false;
		this.userLogin = false;
		this.adminLogin = false;
	}

	public boolean isUserEmailExist() {
		return userEmailExist;
	}


	public void setUserEmailExist(boolean userEmailExist) {
		this.userEmailExist = userEmailExist;
	}



	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public boolean isUserLogin() {
		return userLogin;
	}

	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}

	public String getSample6_postcode() {
		return sample6_postcode;
	}

	public void setSample6_postcode(String sample6_postcode) {
		this.sample6_postcode = sample6_postcode;
	}

	public String getSample6_address() {
		return sample6_address;
	}

	public void setSample6_address(String sample6_address) {
		this.sample6_address = sample6_address;
	}

	public String getSample6_detailAddress() {
		return sample6_detailAddress;
	}

	public void setSample6_detailAddress(String sample6_detailAddress) {
		this.sample6_detailAddress = sample6_detailAddress;
	}

	public String getSample6_extraAddress() {
		return sample6_extraAddress;
	}

	public void setSample6_extraAddress(String sample6_extraAddress) {
		this.sample6_extraAddress = sample6_extraAddress;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}



	
}
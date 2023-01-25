package kr.co.led.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.led.beans.CartListBean;
import kr.co.led.beans.UserBean;
import kr.co.led.beans.WishListBean;

//������Ʈ �۾� �� ����� bean�� �����ϴ� Ŭ����
@Configuration
public class RootAppContext {

	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}

	@Bean("cartListBean")
	@SessionScope
	public CartListBean cartListBean() {
		return new CartListBean();
	}

	@Bean("wishListBean")
	@SessionScope
	public WishListBean wishListBean() {
		return new WishListBean();
	}

	@Bean("adminBean")
	@SessionScope
	public UserBean adminBean() {
		return new UserBean();
	}
}
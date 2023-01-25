package kr.co.led.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.led.beans.CartListBean;

import kr.co.led.beans.OrderUserBean;
import kr.co.led.beans.UserBean;
import kr.co.led.service.CartService;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@Resource(name = "cartListBean")
	CartListBean cartListBean;

// ================================================
	@GetMapping("/order")
	public String order(Model model) {

		int user_idx = loginUserBean.getUser_idx();

		List<CartListBean> orderList = cartService.cartList(user_idx);
		model.addAttribute("orderList", orderList);

		int total = 0;
		int shipping = 0;
		int allTotal = 0;
		float memberDC = 0;
		String showDC = "0 %";

		for (CartListBean list : orderList) {
			total += list.getSubtotal();
		}

		if (total < 100000) {
			shipping = 3000;
		} else {
			shipping = 0;
		}

		// 회원등급별 할인율 적용
		if (loginUserBean.getUser_grade().equals("Diamond")) {
			memberDC = 0.2f;
			showDC = "20 %";
		} else if (loginUserBean.getUser_grade().equals("Gold")) {
			memberDC = 0.1f;
			showDC = "10 %";
		}

		allTotal = (int) (total + shipping - (total * memberDC));

		model.addAttribute("total", total);
		model.addAttribute("shipping", shipping);
		model.addAttribute("showDC", showDC);
		model.addAttribute("allTotal", allTotal);

		OrderUserBean orderUserBean = new OrderUserBean();

		orderUserBean.setUser_name(loginUserBean.getUser_name());
		orderUserBean.setUser_address(loginUserBean.getSample6_address() + ", " + loginUserBean.getSample6_detailAddress());
		orderUserBean.setUser_zip(loginUserBean.getSample6_postcode());
		orderUserBean.setUser_phone(loginUserBean.getUser_phone());
		orderUserBean.setUser_email(loginUserBean.getUser_email());

		model.addAttribute("orderUserBean", orderUserBean);

		return "order/order";
	}

	@GetMapping("checkout_complete")
	public String checkout_complete() {
		return "order/checkout_complete";
	}

}
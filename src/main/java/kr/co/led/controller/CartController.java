package kr.co.led.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.led.beans.CartBean;
import kr.co.led.beans.CartListBean;
import kr.co.led.beans.UserBean;
import kr.co.led.beans.WishListBean;
import kr.co.led.service.CartService;
import kr.co.led.service.WishListService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private WishListService wishListService;

	@Resource(name = "loginUserBean")
	UserBean loginUserBean;

	@Resource(name = "cartListBean")
	CartListBean cartListBean;

	@PostMapping("/cart_add")
	public String cart_add(@ModelAttribute("addCartBean") CartListBean addCartBean) throws Exception {

		if (loginUserBean.isUserLogin() == false) {
			return "user/not_login";

		} else if (loginUserBean.isUserLogin() == true) {
			int user_idx = loginUserBean.getUser_idx();

			addCartBean.setSubtotal(addCartBean.getProduct_price() * addCartBean.getProduct_amount());

			CartBean cartBean = new CartBean();

			cartBean.setUser_idx(user_idx);
			cartBean.setProduct_idx(addCartBean.getProduct_idx());
			cartBean.setProduct_amount(addCartBean.getProduct_amount());

			if (cartService.checkCart(cartBean) > 0) {
				cartService.updateCart(cartBean);

			} else {
				cartService.addCart(cartBean);
			}

			// wishlist에서 addcart로 보내줄떄
			WishListBean wishListBean = new WishListBean();

			wishListBean.setUser_idx(user_idx);
			wishListBean.setProduct_idx(addCartBean.getProduct_idx());

			if (wishListService.checkWishList(wishListBean) > 0) {
				wishListService.deleteWishListSelected(wishListBean);
				return "cart/addCart_success_inwish";
			}
		}

		return "cart/addCart_success";
	}

	@PostMapping("/cartCnt_update")
	public String cart_change(@ModelAttribute("cntUpdateBean") CartListBean cntUpdateBean) throws Exception {

		int user_idx = loginUserBean.getUser_idx();

		cntUpdateBean.setSubtotal(cntUpdateBean.getProduct_price() * cntUpdateBean.getProduct_amount());

		CartBean cartBean = new CartBean();
		cartBean.setUser_idx(user_idx);
		cartBean.setProduct_idx(cntUpdateBean.getProduct_idx());
		cartBean.setProduct_amount(cntUpdateBean.getProduct_amount());

		cartService.changeCnt(cartBean);

		return "cart/cart_change";
	}

	@GetMapping("/cart")
	public String cart(@ModelAttribute("cntUpdateBean") CartListBean cntUpdateBean, Model model) {

		if (loginUserBean.isUserLogin() == false) {
			return "user/not_login";

		} else {
			int user_idx = loginUserBean.getUser_idx();

			List<CartListBean> cartList = cartService.cartList(user_idx);
			model.addAttribute("cartList", cartList);

			int total = 0;
			int shipping = 0;
			int allTotal = 0;
			float memberDC = 0;
			String showDC = "0 %";

			// 장바구니 가격 총합
			for (CartListBean list : cartList) {
				total += list.getSubtotal();
			}

			// 배송비 설정
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

			// 주문 가격
			allTotal = (int) (total + shipping - (total * memberDC));

			model.addAttribute("total", total);
			model.addAttribute("shipping", shipping);
			model.addAttribute("showDC", showDC);
			model.addAttribute("allTotal", allTotal);

			return "cart/cart";
		}
	}

	@GetMapping("/cart_deleteAll")
	public String deleteCartAll() {

		int user_idx = loginUserBean.getUser_idx();

		cartService.deleteCartAll(user_idx);

		return "cart/cart_delete";
	}

	@GetMapping("/cart_deleteSelected")
	public String deleteCartSelected(@RequestParam("product_idx") int product_idx) {

		CartBean cartBean = new CartBean();
		int user_idx = loginUserBean.getUser_idx();

		cartBean.setUser_idx(user_idx);
		cartBean.setProduct_idx(product_idx);

		cartService.deleteCartSelected(cartBean);

		return "cart/cart_delete";
	}

}
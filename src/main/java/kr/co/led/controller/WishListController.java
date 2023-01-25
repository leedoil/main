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

import kr.co.led.beans.CartListBean;
import kr.co.led.beans.UserBean;
import kr.co.led.beans.WishListBean;
import kr.co.led.service.WishListService;

@Controller
public class WishListController {

   @Autowired
   private WishListService wishListService;

   @Resource(name = "loginUserBean")
   UserBean loginUserBean;

   @Resource(name = "wishListBean")
   WishListBean wishListBean;

   @PostMapping("/wishList_add")
   public String wishList_add(@ModelAttribute("addWishListBean") WishListBean addWishListBean) throws Exception {

      if (loginUserBean.isUserLogin() == false) {
         // 로그인 하라는 제약 걸기
         return "user/not_login";

      } else {
         int user_idx = loginUserBean.getUser_idx();

         WishListBean wishListBean = new WishListBean();
         wishListBean.setUser_idx(user_idx);
         wishListBean.setProduct_idx(addWishListBean.getProduct_idx());

         if (wishListService.checkWishList(wishListBean) > 0) {
            return "wishlist/addwishList_fail";
            // 같은 상품 없으면 add
         } else {
            wishListService.addWishList(wishListBean);
            return "wishlist/addwishList_success";
         }

      }
   }

   @GetMapping("/wishlist") // 얘 뭐하는 얜지
   public String wishList(@ModelAttribute("addCartBean") CartListBean addCartBean, Model model) {

      if (loginUserBean.isUserLogin() == false) {
         return "user/not_login";

      } else {
         int user_idx = loginUserBean.getUser_idx();

         List<WishListBean> wishList = wishListService.wishList(user_idx);

         for (WishListBean list : wishList) {
            if (list.getProduct_instock() > 0) {
               list.setStock_status("in stock");

            } else {
               list.setStock_status("sold out");
            }
         }
         model.addAttribute("wishList", wishList);
         return "wishlist/wishlist";
      }
   }

   @GetMapping("/wishlist_deleteAll")
   public String deleteWishListAll() {

      int user_idx = loginUserBean.getUser_idx();

      wishListService.deleteWishListAll(user_idx);

      return "wishlist/wishList_delete";
   }

   @GetMapping("/wishlist_deleteSelected")
   public String deleteCartSelected(@RequestParam("product_idx") int product_idx) {

      WishListBean wishListBean = new WishListBean();
      int user_idx = loginUserBean.getUser_idx();

      wishListBean.setUser_idx(user_idx);
      wishListBean.setProduct_idx(product_idx);

      wishListService.deleteWishListSelected(wishListBean);

      return "wishlist/wishList_delete";
   }

}
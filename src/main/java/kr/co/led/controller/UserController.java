package kr.co.led.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.led.beans.QuestionBean;
import kr.co.led.beans.UserBean;
import kr.co.led.service.QuestionService;
import kr.co.led.service.UserService;
import kr.co.led.validator.UserValidator;

@Controller
public class UserController {

   @Autowired
   UserService userService;

   @Resource(name = "loginUserBean")
   private UserBean loginUserBean;

   @Autowired
	private QuestionService questionService;
   
   @GetMapping("/login")
   public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
         @RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {

      model.addAttribute("fail", fail); // 실패 아니얌

      return "user/login";
   }

   @PostMapping("/login_pro")
   public String tempLoginUserBean(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
         BindingResult result) {

      if (result.hasErrors()) {
         return "user/login";
      }

      userService.getLoginUserInfo(tempLoginUserBean);

      if (loginUserBean.isUserLogin() == true) {
         return "user/login_success";
      } else {
         return "user/login_fail"; // 아이디 비번 검증
      }
   }

   @GetMapping("/join")
   public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {

      return "user/join";
   }

   @PostMapping("/join_pro")
   public String Join(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {

      if (result.hasErrors()) {
         return "user/join";
      }

      userService.addUserInfo(joinUserBean);

      return "user/join_success";
   }

   /* 정보수정 */

   @GetMapping("/check_pw")
   public String check_pw(@ModelAttribute("checkPW") UserBean checkPW) {

      userService.getModifyUserInfo(checkPW);

      return "user/check_pw";
   }
   
   @PostMapping("/check_pw_pro")
   public String check_pw_pro(@ModelAttribute("checkPW") UserBean checkPW, Model model) {
      
      if(checkPW.getUser_pw().equals(loginUserBean.getUser_pw())) {
         int user_idx=loginUserBean.getUser_idx();
         model.addAttribute("user_idx", user_idx);
         return "redirect:/user_modify";
      }
      
      return "user/check_pw_fail";
   }

   @GetMapping("/user_modify")
   public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean,
                  @RequestParam("user_idx") int user_idx, Model model) {
      
      userService.getModifyUserInfo(modifyUserBean); // 수정하지 않아도 되는 id, name
      
      user_idx=loginUserBean.getUser_idx();
      model.addAttribute("user_idx", user_idx);

      return "user/modify";
   }

   @PostMapping("/user_modify_pro")
   public String modify(@Valid @ModelAttribute("modifyUserBean") UserBean modifyUserBean, BindingResult result) {

      if (result.hasErrors()) {

         return "user/modify";
      }
      userService.modifyUserInfo(modifyUserBean);

      loginUserBean.setUser_pw(modifyUserBean.getUser_pw());
      loginUserBean.setUser_pw2(modifyUserBean.getUser_pw2());
      
      return "user/modify_success";
   }

   /* 회원 탈퇴 */
   @GetMapping("/delete")
   public String delete(@RequestParam("user_idx") int user_idx) {

      userService.deleteUserInfo(user_idx);
      loginUserBean.setUserLogin(false);

      return "user/delete";
   }

   @GetMapping("/mypage")
   public String mypage() {
	   return "user/mypage";
   }

   @GetMapping("/logout")
   public String logout() {

      loginUserBean.setUserLogin(false);

      return "user/logout";
   }

   @GetMapping("/not_login")
   public String not_login() {

      return "user/not_login";
   }

   // UserValidator   û
   @InitBinder
   public void initBinder(WebDataBinder binder) {
      UserValidator validator1 = new UserValidator();
      binder.addValidators(validator1);
   }

}
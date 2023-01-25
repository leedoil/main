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

import kr.co.led.beans.PageBean;
import kr.co.led.beans.ProductBean;
import kr.co.led.beans.QuestionBean;
import kr.co.led.beans.UserBean;
import kr.co.led.service.AdminService;
import kr.co.led.service.AnswerService;
import kr.co.led.service.QuestionService;

@Controller
public class AdminController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private AdminService adminService;

	// ======================= user info ===========================
	// userlist로 보내기
	@GetMapping("/admin_userlist")
	public String admin_userlist(@ModelAttribute("changeUserGrade") UserBean changeUserGrade, Model model) {

		List<UserBean> userList = adminService.getUserList();

		model.addAttribute("userList", userList);

		return "admin/userlist";
	}

	@PostMapping("/changeGrade")
	public String changeGrade(@ModelAttribute("changeUserGrade") UserBean changeUserGrade, Model model) {

		adminService.modifyUserInfo(changeUserGrade);
		
		return "redirect:/admin_userlist";
	}
	
	@GetMapping("/admin_productlist")
	public String admin_productlist(@ModelAttribute("changeProduct") ProductBean changeProduct, Model model) {
		
		List<ProductBean> productlist = adminService.getAllProductList();
		
		model.addAttribute("productlist", productlist);
		
		return "admin/productlist";
	}

	@PostMapping("/changePrice")
	public String changePrice(@ModelAttribute("changeProduct") ProductBean changeProduct, Model model) {

		adminService.modifyProductPrice(changeProduct);
		
		return "redirect:/admin_productlist";
	}

	@PostMapping("/changeStock")
	public String changeStock(@ModelAttribute("changeProduct") ProductBean changeProduct, Model model) {

		adminService.modifyProductStock(changeProduct);
		
		return "redirect:/admin_productlist";
	}
	
	@GetMapping("admin_qnalist")
	public String admin_qnalist(Model model) {
		
		List<QuestionBean> qnaList = adminService.getAllQuestion();
		
		model.addAttribute("qnaList", qnaList);
		return "admin/qnaList";
	}
}
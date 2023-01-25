package kr.co.led.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.led.beans.PageBean;
import kr.co.led.beans.ProductBean;
import kr.co.led.beans.QuestionBean;
import kr.co.led.beans.UserBean;
import kr.co.led.dao.AdminDao;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	// 페이지당 번호
	public List<UserBean> getUserList() {
		return adminDao.getUserList();
	}

	public void modifyUserInfo(UserBean adminModifyBean) {
		adminDao.modifyUserInfo(adminModifyBean);
	}

	public List<ProductBean> getAllProductList() {
		return adminDao.getAllProductList();
	}
	
	public void modifyProductPrice(ProductBean modifyPriceBean) {
		adminDao.modifyProductPrice(modifyPriceBean);
	}
	
	public void modifyProductStock(ProductBean modifyStockBean) {
		adminDao.modifyProductStock(modifyStockBean);
	}
	
	public List<QuestionBean> getAllQuestion() {
		return adminDao.getAllQuestion();
	}
}
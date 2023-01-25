package kr.co.led.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.led.beans.ProductBean;
import kr.co.led.dao.ProductDao;

@Service
public class ProductService {

   @Autowired
   private ProductDao productDao;
   
   public List<ProductBean> getProductList(String product_gender) {
      return productDao.getProductList(product_gender);
   }
   
   public List<ProductBean> getMenProductTypeList(String product_colortype) {
      return productDao.getMenProductTypeList(product_colortype);
   }
   
   public List<ProductBean> getWomenProductTypeList(String product_colortype) {
      return productDao.getWomenProductTypeList(product_colortype);
   }
   
   public ProductBean getProductInfo(int product_idx) {
      return productDao.getProductInfo(product_idx);
   }
   
   public List<ProductBean> getSearchProductList(String search) {
	   return productDao.getSearchProductList(search);
   }
   
}
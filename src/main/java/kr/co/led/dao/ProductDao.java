package kr.co.led.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.ProductBean;
import kr.co.led.mapper.ProductMapper;

@Repository
public class ProductDao {
   
   @Autowired
   private ProductMapper productMapper;
   
   public List<ProductBean> getProductList(String product_gender) {
      return productMapper.getProductList(product_gender);
   }
   
   public List<ProductBean> getMenProductTypeList(String product_colortype) {
      return productMapper.getMenProductTypeList(product_colortype);
   }
   
   public List<ProductBean> getWomenProductTypeList(String product_colortype) {
      return productMapper.getWomenProductTypeList(product_colortype);
   }
   
   public ProductBean getProductInfo(int product_idx) {
      return productMapper.getProductInfo(product_idx);
   }
 
   public List<ProductBean> getSearchProductList(String search) {
	   return productMapper.getSearchProductList(search);
   }
   
}
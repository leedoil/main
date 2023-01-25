package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.led.beans.ProductBean;

public interface ProductMapper {
   
   @Select("select product_idx, product_name, product_price, product_gender, product_colortype, product_img1, product_instock "
         + "from product where product_gender=#{product_gender}")
   List<ProductBean> getProductList(String product_gender);
   
   @Select("select product_idx, product_name, product_price, product_gender, product_colortype, product_img1, product_instock "
         + "from product where product_gender='Men' and product_colortype=#{product_colortype}")
   List<ProductBean> getMenProductTypeList(String product_colortype);
   
   @Select("select product_idx, product_name, product_price, product_gender, product_colortype, product_img1, product_instock "
         + "from product where product_gender='Women' and product_colortype=#{product_colortype}")
   List<ProductBean> getWomenProductTypeList(String product_colortype);
   
   @Select("select product_idx, product_name, product_price, product_gender, product_colortype, product_img1, product_img2, product_instock "
         + "from product where product_idx=#{product_idx}")
   ProductBean getProductInfo(int product_idx);
   
   @Select("select product_idx, product_name, product_price, product_gender, product_colortype, product_img1, product_instock "
	         + "from product where product_name like #{search}")
 List<ProductBean> getSearchProductList(String search);
   
}
package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.led.beans.OrderBean;
import kr.co.led.beans.OrderProductBean;
import kr.co.led.beans.ProductBean;


public interface OrderMapper {
   
      @Insert("insert into order_table (user_idx, order_idx, order_date, order_method, order_amount, order_sum) "
            + "values (#{user_idx}, odr_seq.nextval, #{order_date}, #{order_method}, #{order_amount}, #{order_sum})")
      void insertOrder(OrderBean orderBean);
      
      @Insert("insert into order_product_info(order_idx, product_idx, order_product_amount) "
            + "values(#{order_idx}, #{product_idx}, #{order_product_amount})")
      void insertOrderProduct(OrderProductBean orderProductBean);
   
      //=======================================
      
      @Select("select ut.user_name, sample6_postcode, sample6_address, sample6_detailAddress, sample6_extraAddress, user_phone, user_email "
            + "from user_table ut, order_table od "
            + "where ut.user_idx = #{user_idx}")
      OrderBean getOrderInfo(int user_idx);
      
      @Select("select o.order_idx, order_date, order_amount, product_idx "
            + "from order_table o "
            + "join user_table u "
            + "on o.user_idx = u.user_idx "
            + "join order_product_info p "
            + "on o.order_idx = p.order_idx "
            + "where o.order_idx = #{order_idx} "
            + "and o.user_idx = #{user_idx}")
      OrderBean showOrder(OrderBean orderBean); 
      
      @Select("select product_name "
            + "from product "
            + "where product_idx = #{product_idx}")
      String getProductName(int product_idx);
      
      @Select("select * from order_table" )
      List<OrderBean> select_data();
      
      //주문기록
      @Select("select * from order_table order by order_date desc")
      List<OrderBean> getPayAll();


      @Select("select * from order_table " +
            "where user_idx = #{user_idx} " +
            "order by order_date desc")
        List<OrderBean> getCardList(String id);
       

}
package kr.co.led.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.OrderBean;
import kr.co.led.beans.OrderProductBean;
import kr.co.led.mapper.OrderMapper;

@Repository
public class OrderDao {

   @Autowired //mapper 자동생성
   private OrderMapper orderMapper;
      
   public void insertOrder(OrderBean orderBean) {
      orderMapper.insertOrder(orderBean);
   }
   
   public void insertOrderProduct(OrderProductBean orderProductBean) {
      orderMapper.insertOrderProduct(orderProductBean);
   }
   
   public OrderBean getOrderInfo(int user_idx) {
      return orderMapper.getOrderInfo(user_idx);
   }
   
   public OrderBean showOrder(OrderBean orderBean) {
      return orderMapper.showOrder(orderBean);
   }
   
   public String getProductName(int product_idx) {
      return orderMapper.getProductName(product_idx);
   }
   
   public List<OrderBean> select_data() {
      return orderMapper.select_data();
   }

   public List<OrderBean> getCardList(String id){
      return orderMapper.getCardList(id);
   }
   
   public List<OrderBean> getPayAll(){
      return orderMapper.getPayAll();
   }
   

}
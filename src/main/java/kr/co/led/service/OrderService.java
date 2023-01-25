package kr.co.led.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.led.beans.OrderBean;
import kr.co.led.beans.OrderProductBean;
import kr.co.led.beans.UserBean;
import kr.co.led.dao.OrderDao;

@Service
public class OrderService {

   

   @Autowired
   private OrderDao orderDao;

   @Resource(name = "loginUserBean")
   private UserBean loginUserBean;


   public void insertOrder(OrderBean orderBean) {
      orderDao.insertOrder(orderBean);
   }
   
   public void insertOrderProduct(OrderProductBean orderProductBean) {
      orderDao.insertOrderProduct(orderProductBean);
   }
   
   public OrderBean getOrderInfo(int user_idx) {
      return orderDao.getOrderInfo(user_idx);
   }
   
   public OrderBean showOrder(OrderBean orderBean) {
      return orderDao.showOrder(orderBean);
   }
   
   public String getProductName(int product_idx) {
      return orderDao.getProductName(product_idx);
   }
   
   public List<OrderBean> select_data() {
      return orderDao.select_data();
   }

   public List<OrderBean> getCardList(String id){
      return orderDao.getCardList(id);
   }
   
   public List<OrderBean> getPayAll(){
      return orderDao.getPayAll();
   }
   
   

}
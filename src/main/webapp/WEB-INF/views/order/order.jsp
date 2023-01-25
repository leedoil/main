<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>COLURR</title>

    <!--== Favicon ==-->
    <link rel="shortcut icon" href="assets/img/prelogo.png" type="image/x-icon" />

    <!--== Google Fonts ==-->
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface:400" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,400i,500,600,700,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,700,900,900i" rel="stylesheet">

    <!--== Bootstrap CSS ==-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <!--== Font-awesome Icons CSS ==-->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet"/>
    <!--== Icofont Min Icons CSS ==-->
    <link href="assets/css/icofont.min.css" rel="stylesheet"/>
    <!--== lastudioIcons CSS ==-->
    <link href="assets/css/lastudioIcons.css" rel="stylesheet"/>
    <!--== Animate CSS ==-->
    <link href="assets/css/animate.css" rel="stylesheet"/>
    <!--== Aos CSS ==-->
    <link href="assets/css/aos.css" rel="stylesheet"/>
    <!--== FancyBox CSS ==-->
    <link href="assets/css/jquery.fancybox.min.css" rel="stylesheet"/>
    <!--== Slicknav CSS ==-->
    <link href="assets/css/slicknav.css" rel="stylesheet"/>
    <!--== Swiper CSS ==-->
    <link href="assets/css/swiper.min.css" rel="stylesheet"/>
    <!--== Slick CSS ==-->
    <link href="assets/css/slick.css" rel="stylesheet"/>
    <!--== Main Style CSS ==-->
    <link href="assets/css/style.css" rel="stylesheet" />
   <!--== Pay JS -->
</head>
   <!-- PAY 버튼 -->
   <script type="text/javascript" src="assets/js/pay.js"></script>

<!-- 아임포트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<body>
<c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>

  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-img" data-bg-img="assets/img/photos/bg-page1.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title">Pay</h2>
              <div class="bread-crumbs"><a href="${root }main">Home<span class="breadcrumb-sep">></span></a><span class="active">Pay</span></div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Page Title Area ==-->

    <!--== Start Shop Checkout Area ==-->
    <section class="shop-checkout-area">
      <div class="container">
        <div class="row ">
          <div class="col-lg-8 col-md-12">
            <div class="shop-billing-form">
              <form action="${root }order_list" method="post">
                <h4 class="title">Billing details</h4>
                <div class="row">
                  <div class="col-md-6">
                    <div class="form-group" style="width:100%">
                      <label for="cf_name">Name <abbr class="required" title="required"></abbr></label>
                      <input class="form-control" id="cf_name" type="text" readonly="true" value="${orderUserBean.user_name}" style="width:770px">
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="cf_street_address">Address <abbr class="required" title="required"></abbr></label>
                  <input class="form-control" id="cf_street_address" type="text" readonly="true" value="${orderUserBean.user_address}">
                </div>

                <div class="form-group">
                  <label for="cf_zip">ZIP <abbr class="required" title="required"></abbr></label>
                  <input class="form-control" id="cf_zip" type="text" readonly="true" value="${orderUserBean.user_zip}">
                </div>

                <div class="form-group">
                  <label for="cf_phone">Phone <abbr class="required" title="required"></abbr></label>
                  <input class="form-control" id="cf_phone" type="text" readonly="true"  value="${orderUserBean.user_phone}">
                </div>

                <div class="form-group">
                  <label for="cf_email">Email address <abbr class="required" title="required"></abbr></label>
                  <input class="form-control" id="cf_email" type="text" readonly="true" value="${orderUserBean.user_email}">
                </div>
              </form>
            </div>
          </div>
      <!-- =================================주문목록================================= -->
          <div class="col-lg-4 col-md-12">
            <h4 class="title">Your order</h4>
            <div class="order-review-details">
              <table class="table">
                <thead>
                  <tr>
                    <th>Product</th>
                    <th>Subtotal</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="list" items="${orderList}">
                    <tr>
                      <td>
                        <span class="product-title">${list.product_name}</span>
                        <span class="product-quantity"> × ${list.product_amount}</span>
                      </td>
                      <td><fmt:formatNumber value="${list.subtotal}" pattern="###,###"/></td>
                    </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <tr class="cart-subtotal">
                    <th>Subtotal</th>
                    <td><fmt:formatNumber value="${total}" pattern="###,###"/></td>
                  </tr>
                  <tr class="cart-subtotal">
                    <th>Member Discount</th>
                    <td>${showDC}</td>
                  </tr>
                  <tr class="cart-subtotal">
                    <th>Shipping</th>
                    <td><fmt:formatNumber value="${shipping}" pattern="###,###"/></td>
                  </tr>
                  <tr class="final-total">
                    <th>Total</th>
                    <td><span class="total-amount" id="alltotal">${allTotal} &nbsp; won</span></td>
                  </tr>
                </tfoot>
              </table>
              
              <script>
              var allTotal = ${allTotal};
              </script>
              

            </div>
            <button class="btn place-order-btn" type="button" onclick="payment();">Pay</button>
          </div>
        </div>
      </div>
    </section>
    <!--== End Shop Checkout Area ==-->
  </main>
<c:import url="/WEB-INF/views/include/bottom_info.jsp"></c:import>
<!--=======================Javascript============================-->

<!--=== Modernizr Min Js ===-->
<script src="assets/js/modernizr.js"></script>
<!--=== jQuery Min Js ===-->
<script src="assets/js/jquery-main.js"></script>
<!--=== jQuery Migration Min Js ===-->
<script src="assets/js/jquery-migrate.js"></script>
<!--=== Popper Min Js ===-->
<script src="assets/js/popper.min.js"></script>
<!--=== Bootstrap Min Js ===-->
<script src="assets/js/bootstrap.min.js"></script>
<!--=== jquery Appear Js ===-->
<script src="assets/js/jquery.appear.js"></script>
<!--=== jquery Swiper Min Js ===-->
<script src="assets/js/swiper.min.js"></script>
<!--=== jquery Fancybox Min Js ===-->
<script src="assets/js/fancybox.min.js"></script>
<!--=== jquery Aos Min Js ===-->
<script src="assets/js/aos.min.js"></script>
<!--=== jquery Slicknav Js ===-->
<script src="assets/js/jquery.slicknav.js"></script>
<!--=== jquery Countdown Js ===-->
<script src="assets/js/jquery.countdown.min.js"></script>
<!--=== jquery Tippy Js ===-->
<script src="assets/js/tippy.all.min.js"></script>
<!--=== Isotope Min Js ===-->
<script src="assets/js/isotope.pkgd.min.js"></script>
<!--=== jquery Vivus Js ===-->
<script src="assets/js/vivus.js"></script>
<!--=== Parallax Min Js ===-->
<script src="assets/js/parallax.min.js"></script>
<!--=== Slick  Min Js ===-->
<script src="assets/js/slick.min.js"></script>
<!--=== jquery Wow Min Js ===-->
<script src="assets/js/wow.min.js"></script>
<!--=== jquery Zoom Min Js ===-->
<script src="assets/js/jquery-zoom.min.js"></script>

<!--=== Custom Js ===-->
<script src="assets/js/custom.js"></script>

</body>

</html>
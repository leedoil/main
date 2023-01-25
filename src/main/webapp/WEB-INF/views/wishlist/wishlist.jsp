<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>

<body>

<!--wrapper start-->
<div class="wrapper page-wishlist-wrapper">

  <c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>
  
  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-img" data-bg-img="assets/img/photos/bg-page5.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title">Wishlist</h2>
              <div class="bread-crumbs"><a href="index.html">Home<span class="breadcrumb-sep">></span></a><span class="active">Wishlist</span></div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!--== Start Cart Area Wrapper ==-->
    <div class="product-area wishlist-page-area" style="margin-bottom:170px">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="wishlist-table-wrap">
              <div class="wishlist-table table-responsive">
                <table>
                  <thead>
                    <tr>
                      <th class="pro-remove"> </th>
                      <th class="pro-name">Product</th>
                      <th class="pro-stock-status">Stock Status</th>
                      <th class="pro-price">Price</th>
                      <th class="pro-action"> </th>
                    </tr>
                  </thead>
                  <tbody>
               <c:forEach var="list" items="${wishList }">
                      <tr>
                       <form:form method="post" action="${root}cart_add" modelAttribute="addCartBean">
                         <input type="hidden" name="product_idx" value="${list.product_idx}">  
                         <input type="hidden" name="product_price" value="${list.product_price}">
                         <input type="hidden" name="product_amount" title="Quantity" value="1" />
                         <td class="pro-remove"><a class="lastudioicon-e-remove" href="${root}wishlist_deleteSelected?product_idx=${list.product_idx}" ></a></td>
                         <td class="pro-name" style="width:100px"><span><a href="${root}product_detail?product_idx=${list.product_idx}">${list.product_name}</a></span></td>
                         <td class="pro-stock-status" style="width:100px"><span>${list.stock_status}</span></td>
                         <td class="pro-price" style="width:80px"><span><fmt:formatNumber value="${list.product_price}" pattern="###,###"/></span></td>
                         <td class="pro-action"><form:button class="btn-theme btn-black">Add to cart</form:button></td>
                        </form:form>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="coupon-action">
              <button class="button" onclick="location.href='${root}wishlist_deleteAll'" style="text-align:left">Delete All</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--== End Cart Area Wrapper ==-->

  </main>

  <c:import url="/WEB-INF/views/include/bottom_info.jsp"></c:import>
   
  <!--== End Side Menu ==-->
</div>

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
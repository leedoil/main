<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="zxx">

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
<div class="wrapper shop-fullwidth-wrapper">

  <c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>
  
  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-img" data-bg-img="assets/img/shop2.png">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title">Shop</h2>
              <div class="bread-crumbs"><a href="index.html">${product_gender}<span class="breadcrumb-sep">></span></a><span class="active">${product_colortype}</span></div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Page Title Area ==-->

    <!--== Start Products Area Wrapper ==-->
    <div class="product-area shop-fullwidth-area style-two">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="row">
               <div class="col-12 product-items-list">
                  <c:forEach var="obj" items="${productList}">
                  
                    <!-- Start Product Item -->
                    <div class="product-item" style="float: left; width: 50%;">
                      <div class="product-thumb">
                        <a href="${root}product_detail?product_idx=${obj.product_idx}">
                          <img src="assets/img/product/${obj.product_img1}">
                          <span class="thumb-overlay"></span>
                        </a>
                      </div>
                      <div class="product-info">
                        <div class="content-inner">                  
                          <h4 class="title"><a href="${root}product_detail?product_idx=${obj.product_idx}">${obj.product_name}</a></h4>
                          <div class="prices">
                            <span class="price"><fmt:formatNumber value="${obj.product_price}" pattern="###,###"/> &nbsp; won</span>
                          </div>
                          <div class="product-action-btn">
                           <form:form method="post" action="${root}cart_add" modelAttribute="addCartBean">
                            <input type="hidden" name="product_idx" value="${obj.product_idx}"> 
                            <input type="hidden" name="product_amount" value=1>
                            <c:choose>
                              <c:when test="${obj.product_instock == 0}">
                                <form:button class="btn-add-cart btn-theme" disabled='true'>Sold Out</form:button>
                              </c:when>
                              <c:otherwise>
                                <form:button class="btn-add-cart btn-theme">Add to cart</form:button>
                              </c:otherwise>
                            </c:choose>
                           </form:form>
                            
                           <form:form method="post" action="${root}wishList_add" modelAttribute="addWishListBean">
                             <input type="hidden" name="product_idx" value="${obj.product_idx}">
                             <div  style="border:0px; outline:none; cursor:pointer; border-width: 0px; background-color=#FFFFFF">
                             <button type="submit" class="btn-add-cart btn-theme">
                            <i class="lastudioicon-heart-2"></i>
                            </button>
                            </div>
                          </form:form>     

      
   
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- End Product Item -->
                  
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--== End Products Area Wrapper ==-->
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
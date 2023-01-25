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

</head>

<body>

<!--wrapper start-->
<div class="wrapper home-default-wrapper">

  <c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>
  
  <main class="main-content site-wrapper-reveal">
    <!--== Start Page Title Area ==-->
    <div class="page-title-area page-title-area2">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content content-style-2">
              <div class="bread-crumbs"><a href="index.html">${showProductBean.product_gender}<span class="breadcrumb-sep">></span></a><a href="index.html">${showProductBean.product_colortype}<span class="breadcrumb-sep">></span></a><span class="active">${showProductBean.product_name}</span></div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--== End Page Title Area ==-->

    <!--== Start Shop Area ==-->
    <section class="product-area shop-single-product">
      <div class="container">
        <div class="row">
          <div class="col-lg-6" style="padding-top:50px">
            <div class="single-product-slider ml-0">
              <div class="product-dec-slider-right w-100">
                <div class="single-product-thumb pl-0">
                  <div class="single-product-thumb-slider">
                    <div class="thumb-item">
                      <a class="lightbox-image" data-fancybox="gallery" href="assets/img/product/${showProductBean.product_img1}">
                        <img src="assets/img/product/${showProductBean.product_img1}">
                      </a>
                    </div>
                  </div>
                  <div class="product-gallery-actions">
                    <a class="lightbox-image" data-fancybox="gallery" href="assets/img/product/${showProductBean.product_img1}">
                      <i class="lastudioicon-full-screen"></i>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-6">
            <div class="single-product-info">
              <h4 class="title">${showProductBean.product_name}</h4>
              <div class="product-rating">
                <div class="review">
                  <p><span></span>${showProductBean.product_instock}</p>
                </div>
              </div>
              <div class="prices">
                <span class="price"><fmt:formatNumber value="${showProductBean.product_price}" pattern="###,###"/> won</span>
              </div>
              <div class="quick-product-action">
               <form:form method="post" action="${root}cart_add" modelAttribute="addCartBean">
                 <input type="hidden" name="product_idx" value="${product_idx}"> 
                 <input type="hidden" name="product_name" value="${showProductBean.product_name}"> 
                 <input type="hidden" name="product_price" value="${showProductBean.product_price}"> 
                 <input type="hidden" name="product_img1" value="${showProductBean.product_img1}"> 
                  <div class="action-top">
                    <div class="pro-qty-area">
                      <div class="pro-qty">
                        <form:input id="quantity1" path="product_amount" title="Quantity" value="1" />
                      </div>
                    </div>
                    <c:choose>
                      <c:when test="${showProductBean.product_instock == 0}">
                        <form:button class="btn-add-cart btn-theme" disabled='true'>Sold Out</form:button>
                      </c:when>
                              
                      <c:otherwise>
                        <form:button class="btn-add-cart btn-theme">Add to cart</form:button>
                      </c:otherwise>
                    </c:choose>
                  </div>
                </form:form>
                <form:form method="post" action="${root}wishList_add" modelAttribute="addWishListBean">
                  <input type="hidden" name="product_idx" value="${product_idx}">
            	    <div class="action-bottom">
            	      <button type="submit" class="btn-add-cart btn-theme">Add to wishlist</button>
            	    </div>
                </form:form>
                  </div>
              </div>
              <div class="product-categorys">
                <div class="product-category">
                  ColorType: <span>${showProductBean.product_colortype}</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Shop Area ==-->

    <!--== Start Shop Tab Area ==-->
    <section class="product-area product-description-review-area">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="product-description-review">
              <ul class="nav nav-tabs product-description-tab-menu" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active" id="product-desc-tab" data-bs-toggle="tab" data-bs-target="#productDesc" type="button" role="tab" aria-controls="productDesc" aria-selected="true">Description</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="product-review-tab" data-bs-toggle="tab" data-bs-target="#productReview" type="button" role="tab" aria-controls="productReview" aria-selected="false">Reviews (${reviewCnt})</button>
                </li>
              </ul>
              <div class="tab-content product-description-tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="productDesc" role="tabpanel" aria-labelledby="product-desc-tab">
                  <div class="product-desc" style="width:1400px">
                    <div class="product-desc-row">
                      <img src="assets/img/product/${showProductBean.product_img2}"/>
                    </div>
                  </div>
                </div>
                <!-- 리뷰 -->
                <div class="tab-pane fade" id="productReview" role="tabpanel" aria-labelledby="product-review-tab">
                  <div class="product-review">
                    <div class="product-review-comments">
                      <h4 class="title">${reviewCnt} review for <span>${showProductBean.product_name}</span></h4>
                      <c:choose>
                        <c:when test="${reviewList == null}">
                          <h6 class="review">There are no reviews yet.</h6>
                        </c:when>
                        <c:otherwise>
                         <c:forEach var="list" items="${reviewList }">
                          <div class="comment-item">
                           <div class="content">
                            <div class="rating"> ${list.review_star} </div>
                            <h5 class="meta"><span>[ ${list.user_name } ] </span> / ${list.review_date}</h5>
                            <span class="review">${list.review_content }</span>
                           </div>
                         </div>
                        </c:forEach>
                       </c:otherwise>
                      </c:choose>
                    </div>
                    <form:form method="post" action="${root}review_write_pro" modelAttribute="writeReviewBean">
                    <input type="hidden" name="product_idx" value="${product_idx}"/>
                    <div class="product-review-form">
                      <h3 class="title">Add a review</h3>
                      <div class="rating">
                        <span class="rating-title">Your rating *</span>
                        <div class='form-group'>
                         <input type='radio' name='review_star' value='★'/> ★
                         <input type='radio' name='review_star' value='★★'/> ★★
                         <input type='radio' name='review_star' value='★★★'/> ★★★
                         <input type='radio' name='review_star' value='★★★★'/> ★★★★
                         <input type='radio' name='review_star' value='★★★★★'/> ★★★★★
                       </div>
                      </div>
                        <div class="review-form-content">
                          <div class="row">
                            <div class="col-md-12">
                              <div class="form-group">
                                <label for="reviewFormTextarea">Your review *</label>
                                <textarea class="form-control" id="reviewFormTextarea" name="review_content" rows="7" required></textarea>
                          		<form:errors path="review_content" style="color: red" />
                              </div>
                            </div>
                          </div>
                          <p/>
                          <div class="row">
                            <div class="col-md-12">
                              <div class="form-group">
                                <form:button class="btn btn-theme btn-black">Submit</form:button>
                              </div>
                            </div>
                          </div>
                        </div>
                       </div>
                      </form:form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Shop Tab Area ==-->

  </main>

  <c:import url="/WEB-INF/views/include/bottom_info.jsp"></c:import>
  
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
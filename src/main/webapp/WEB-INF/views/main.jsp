<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <c:import url="/WEB-INF/views/include/top_menu.jsp"/>


<div class="wrapper home-default-wrapper">

 


  <main class="main-content">
    <!--== Start Hero Area Wrapper ==-->
    <section class="home-slider-area slider-default">
      <div class="home-slider-content">
        <div class="swiper-container home-slider-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <!-- Start Slide Item -->
              <div class="home-slider-item">
                <div class="bg-thumb bg-overlay bg-img" data-bg-img="assets/img/slider/m4.jpg"></div>
                <div class="slider-content-area">
                  <div class="container">
                    <div class="row align-items-center">
                      <div class="col-md-8 col-lg-5 m-auto">
                        <div class="content" style="width:700px; position: relative; left: -120px; top: 30%;" >
                          <div class="inner-content">
                            <h2>COLURR</h2>
                            <p>choose your color</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Slide Item -->
            </div>
            <div class="swiper-slide">
              <!-- Start Slide Item -->
              <div class="home-slider-item">
                <div class="bg-thumb bg-overlay bg-img" data-bg-img="assets/img/slider/m2.jpg"></div>
                <div class="slider-content-area">
                  <div class="container">
                    <div class="row align-items-center">
                      <div class="col-md-8 col-lg-5 m-auto">
                        <div class="content" style="width:700px; position: relative; left: -120px; top: 30%;">
                          <div class="inner-content">
                            <h2>STYLE</h2>
                            <p>about your own style</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Slide Item -->
            </div>
            <div class="swiper-slide">
              <!-- Start Slide Item -->
              <div class="home-slider-item">
                <div class="bg-thumb bg-overlay bg-img" data-bg-img="assets/img/slider/m3.jpg"></div>
                <div class="slider-content-area">
                  <div class="container">
                    <div class="row align-items-center">
                      <div class="col-md-8 col-lg-5 m-auto">
                        <div class="content" style="width:700px; position: relative; left: -120px; top: 30%;">
                          <div class="inner-content">
                            <h2>BEAUTY</h2>
                            <p>show your beauty</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Slide Item -->
            </div>
          </div>
          <!-- Add Arrows -->
          <div class="swiper-button-next"></div>
          <div class="swiper-button-prev"></div>
          <!-- Add Pagination -->
          <div class="swiper-pagination"></div>
        </div>
      </div>
    </section>
    <!--== End Hero Area Wrapper ==-->

    <!--== Start Collection Slider Area Wrapper ==-->
    <section class="collection-slider-area">
      <div class="collection-slider-content">
        <div class="swiper-container collection-slider-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <!-- Start Slide Item -->
              <div class="slider-item">
                <div class="thumb">
                  <div class="bg-thumb bg-overlay bg-img" data-bg-img="assets/img/slider/d1.jpg"></div>
                </div>
                <div class="slider-content-area">
                  <div class="content">
                    <div class="inner-content">
                      <span>2022</span>
                      <h2>F/W New Arrival</h2>
                      <p>LOOK</p>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Slide Item -->
            </div>
            <div class="swiper-slide">
              <!-- Start Slide Item -->
              <div class="slider-item" style="margin-bottom:200px">>
                <div class="thumb">
                  <div class="bg-thumb bg-overlay bg-img" data-bg-img="assets/img/slider/d2.jpg"></div>
                </div>
                <div class="slider-content-area">
                  <div class="content">
                    <div class="inner-content">
                      <span>Hot</span>
                      <h2>Hot items of this month</h2>
                      <p>LOOK</p>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Slide Item -->
            </div>
          </div>          
          <!-- Add Arrows -->
          <div class="swiper-button-prev"></div>
          <div class="swiper-button-next"></div>
        </div>
      </div>
    </section>
    <!--== End Collection Slider Area Wrapper ==-->

   

    
  </main>

  
  
</div>

  <c:import url="/WEB-INF/views/include/bottom_info.jsp"/>
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
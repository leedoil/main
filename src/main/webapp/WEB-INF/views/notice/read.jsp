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
<link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon" />

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
  <c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>

<!-- <div class="wrapper page-blog-wrapper"> -->

  
  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-img" data-bg-img="assets/img/photos/bg-page1.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title" style="text-transform:uppercase;">${readNoticeBean.notice_type}</h2>
              <div class="bread-crumbs"><a href="${root }notice_list">NOTICE<span class="breadcrumb-sep">></span></a><span class="active">${readNoticeBean.notice_type}</span></div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Page Title Area ==-->

      <!--== Start Blog Area Wrapper ==-->
    <section class="blog-details-area">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="blog-content-column">
              <div class="blog-content-area no-sidebar">
                <div class="post-details-content">
                  <div class="post-details-body">
                    <div class="content" style="text-align:center">
                      
                      
                     <!-- 여기 -->
                      
                      <%-- <form:form action="${root }notice_read" method="get" modelAttribute="readNoticeBean" enctype="multipart/form-data" style="text-align:center">
                      
                      <form:hidden path="notice_idx"/>
                       --%>
                      <!-- notice 카테고리 > 누르면 list로 이동  -->
                     <div class="notice_type">
                        <a href="${root }notice_list?notice_type=${readNoticeBean.notice_type}" style="text-transform:uppercase;">${readNoticeBean.notice_type}</a>   
                     </div>
                         
                      <!-- 제목 -->
                      <h4>${readNoticeBean.notice_title }</h4>                   
                         
                      <!-- 작성날짜 -->   
                      <p class="notice_date" style="font-size: 14px">${readNoticeBean.notice_date }</p>    
                      <hr />
                         
                     <!-- 내용 -->   
                     <p style="width:200px"> </p>
                     <textarea>${readNoticeBean.notice_context }</textarea>         
                      <p class="notice_context"></p>
                      <hr />
                     
                     
                     
                     <!-- 하단 버튼 -->
                    <div>
                      <a href="${root }notice_list?notice_type=${readNoticeBean.notice_type}&page=${page}" class="btn-theme btn btn-black">목록보기</a>
                      <c:if test="${admin_idx == 1 && loginUserBean.userLogin == true}">
                         <a href="${root }notice_modify?notice_type=${readNoticeBean.notice_type}&notice_idx=${notice_idx}&page=${page}" class="btn-theme btn btn-black">수정하기</a>
                          <a href="${root }notice_delete?notice_type=${readNoticeBean.notice_type}&notice_idx=${notice_idx}&page=${page}" class="btn-theme btn btn-black">삭제하기</a>
                        </c:if>
                    </div>
                   
                   
                   <%-- </form:form> --%>
                   
                   </div>
                    
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Blog Area Wrapper ==-->

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
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
  <c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>
<div class="wrapper page-blog-wrapper">

  
  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-img" data-bg-img="assets/img/photos/bg-page1.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title">Blog</h2>
              <div class="bread-crumbs"><a href="${root }main">Home<span class="breadcrumb-sep">></span></a><a href="${root }main">Blog</a><span class="breadcrumb-sep">></span><span class="active">Blog Details</span></div>
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
                    
                      <h2 style="text-align:center">답변대기</h2><p/>
					<form:form action="${root }board_answer_pro" method="post" modelAttribute="writeAnswerBean" enctype="multipart/form-data" >
                    <div class="content" style="text-align:left">
                    <input type="hidden" name='page' value='${page }'/>
                    <form:hidden path="question_idx" />
                      <!-- 여기 -->
                      <div class="content" style="text-align:center">
                      
                    
                     <label for="question_title" >${readQuestionBean.question_title }</label><p/>
                     <label for="writer" style="font-size: 14px">${readQuestionBean.writer_name } </label><p/>
                     <label for="question_date" style="font-size: 14px">${readQuestionBean.question_date } </label><p/>
                      <hr />
                     <label for="question_content">${readQuestionBean.question_content }</label>
                     
                      <c:if test="${readQuestionBean.question_img != null }">
                      <ul class="meta">
                        <li class="question_img">첨부 이미지</li>
                        <li> | </li>
                        <li><img src="${root }upload/${readQuestionBean.question_img}" width="20%"/></li>
                      </ul>
                      </c:if>
                      
                      <p class="m-0"></p>
                     
                      <%-- </c:forEach> --%>
	
                    </div>
                     <hr />
                    <div class="comments-area" style="margin:30px">
                    
                      <h2>답변 작성</h2>
                      <div class="comments-form-wrap">
                        <div class="clearfix"></div>
                        
                          <div class="comments-form-content">
                            <div class="row row-gutter-20">
                              <div class="col-md-12">
                                <div class="form-group">
                                                    
                                  <form:textarea path="answer_content" class="form-control"  rows="5" placeholder="답변을 작성해주세요" style="resize:none" />
                                </div>
                              </div>
                            </div>
                            </div>
                            
                              <div class="col-md-12">
                              <p>
                              <div class="form-group">
                                <div style="text-align:center">
                                
                               
                                
                                
                                    <button class="btn-theme btn btn-black" style="width:150px" >제출하기</button>
                                    </div>
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
      
    </section>
    <!--== End Blog Area Wrapper ==-->

  </main>

  
</div>
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
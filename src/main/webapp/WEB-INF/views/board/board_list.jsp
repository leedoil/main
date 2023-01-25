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
<c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>

<!--wrapper start-->
<div class="wrapper page-blog-wrapper">

  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-img" data-bg-img="assets/img/photos/bg-page1.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title">Q&A</h2>
              <div class="bread-crumbs"><a href="${root }main">Home<span class="breadcrumb-sep">></span></a><span class="active">Q&A</span></div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Page Title Area ==-->

    <!--== Start Blog Area Wrapper ==-->
    <section class="blog-area blog-grid-area">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="blog-content-column">
              <div class="blog-content-area no-sidebar">
               
               <!-- 게시판 시작 -->
                <h2 id="board_title">Q&A</h2>
                <table>
                <tr id="board_sub">
	                <td>
	                <%-- <a href="${root }board_question">글쓰기</a> --%>
	                	<div style="text-align: right">
               			<a href="${root }board_write" style="margin-right:900px ">글쓰기</a>
                		
						</div>
					</td>
				</tr>
				</table>
                
            <table id='board_list'>
               <thead>
                  <tr id="board_content_info">
                     <th>글번호</th>
                     <th>제목</th>
                     <th>작성자</th>
                     <th>작성날짜</th>
                  </tr>
               </thead>
               <tr />
               <tbody>
                 
                   <c:forEach var='obj' items="${questionList }">
	                 <tr id="board_content">
	                   <td>${obj.question_idx }</td>
	                   <td><a href="${root }board_read?question_idx=${obj.question_idx}&page=${page}">${obj.question_title }</a></td>
	                   <td>${obj.user_name }</td>
	                   <td>${obj.question_date }</td>
	                 </tr>
                   </c:forEach>
                 
               </tbody>
               </table>
				
               
            
            <!-- 게시판 끝 -->
                
               <!-- 페이징 처리 -->
                <div class="pagination-area">
                  <nav>
                    <ul class="page-numbers">
                    	<!-- 이전페이지가 1이하이면 비활성화 -->
						<c:choose>
							<c:when test="${pageBean.prevPage <= 0 }">
							
							<li class="page-number disabled">
								<a href="#" class="page-link">이전</a>
							</li>
							</c:when>
							
							<c:otherwise>
							<li class="page-number">
								<a href="${root }board_list?page=${pageBean.prevPage}" class="page-link">이전</a>
							</li>
							</c:otherwise>
						</c:choose>	
						
						
						<c:forEach var='idx' begin="${pageBean.min }" end='${pageBean.max }'>
						<!-- 현재페이지면 active(부트스트랩) 적용 -->
						<c:choose>
							<c:when test="${idx == pageBean.currentPage }">
							<li class="page-number active">
								<a href="${root }board_list?page=${idx}" class="page-link">${idx }</a>
							</li>
							</c:when>
							<c:otherwise>
							<li class="page-number">
								<a href="${root }board_list?page=${idx}" class="page-link">${idx }</a>
							</li>
							</c:otherwise>
						</c:choose>
						</c:forEach>
						
							
						<!-- Max값이 전체페이지보다 크거나 같으면 비활성화   disabled(부트스트랩) -->
						<c:choose>
						<c:when test="${pageBean.max >= pageBean.pageCnt }">
						<li class="page-number disabled">
							<a href="#" class="page-link">다음</a>
						</li>
						</c:when>
						<c:otherwise>
						<li class="page-number">
							<a href="${root }board_list?page=${pageBean.nextPage}" class="page-link">다음</a>
						</li>
						</c:otherwise>
						</c:choose>	
						
					</ul>
                  </nav>
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
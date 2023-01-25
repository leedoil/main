<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath}/" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>COLURR</title>

<!--== Favicon ==-->
<link rel="shortcut icon" href="assets/img/favicon.ico"
	type="image/x-icon" />

<!--== Google Fonts ==-->
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface:400"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,400i,500,600,700,900,900i"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,700,900,900i"
	rel="stylesheet">

<!--== Bootstrap CSS ==-->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<!--== Font-awesome Icons CSS ==-->
<link href="assets/css/font-awesome.min.css" rel="stylesheet" />
<!--== Icofont Min Icons CSS ==-->
<link href="assets/css/icofont.min.css" rel="stylesheet" />
<!--== lastudioIcons CSS ==-->
<link href="assets/css/lastudioIcons.css" rel="stylesheet" />
<!--== Animate CSS ==-->
<link href="assets/css/animate.css" rel="stylesheet" />
<!--== Aos CSS ==-->
<link href="assets/css/aos.css" rel="stylesheet" />
<!--== FancyBox CSS ==-->
<link href="assets/css/jquery.fancybox.min.css" rel="stylesheet" />
<!--== Slicknav CSS ==-->
<link href="assets/css/slicknav.css" rel="stylesheet" />
<!--== Swiper CSS ==-->
<link href="assets/css/swiper.min.css" rel="stylesheet" />
<!--== Slick CSS ==-->
<link href="assets/css/slick.css" rel="stylesheet" />
<!--== Main Style CSS ==-->
<link href="assets/css/style.css" rel="stylesheet" />

</head>

<body>

	<!--wrapper start-->
	<div class="wrapper">

		<!-- 상단 header -->
		<c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>


		<main class="main-content">


			<!--== Start Page Title Area ==-->
			<section class="page-title-area bg-img"
				data-bg-img="assets/img/photos/bg-page1.jpg">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="page-title-content">
								<h2 class="title" style="text-transform: uppercase;">${notice_type}</h2>
								<div class="bread-crumbs">
									<a href="${root }notice_list">NOTICE<span
										class="breadcrumb-sep">></span></a><span class="active">${notice_type}</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!--== End Page Title Area ==-->

			<section class="blog-area blog-grid-area">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<div class="blog-content-column">
								<div class="blog-content-area no-sidebar">
									<!-- 게시판 시작 -->
									<h2 id="board_title" style="text-transform: uppercase;">${notice_type}</h2>
									<table id='board_list' style="width:1500px" >
										<thead>
											<tr id="board_content_info">
												<th>글번호</th>
												<th>제목</th>
												<th>작성날짜</th>
											</tr>
										</thead>

										<tr />

										<tbody>
											<c:forEach var='obj' items="${noticeList }">
												<tr id="board_content">
													<td>${obj.notice_idx }</td>
													<td><a
														href="${root }notice_read?notice_type=${notice_type}&notice_idx=${obj.notice_idx}&page=${page}">${obj.notice_title }</a></td>
													<td>${obj.notice_date}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- 게시판 끝 -->


									<div class="pagination-area">
										<nav>
											<ul class="page-numbers">


												<!-- 이전 버튼 -->
												<c:choose>
													<c:when test="${pageBean.prevPage <= 0 }">
														<li class="page-number disabled"><a href="#"
															class="page-link" style="color: gray"> < </a></li>
													</c:when>

													<c:otherwise>
														<li class="page-number"><a
															href="${root }notice_list?notice_type=${notice_type}&page=${pageBean.prevPage}"
															class="page-link" style="color: black"><</a></li>
													</c:otherwise>
												</c:choose>


												<!-- 페이지 버튼 -->
												<c:forEach var='idx' begin="${pageBean.min }"
													end="${pageBean.max }">
													<c:choose>
														<c:when test="${idx == pageBean.currentPage }">
															<!-- ★★★★[css 요청] 현재페이지 나타내는 스타일 -->
															<li class="page-number active"><a
																href="${root }notice_list?notice_type=${notice_type}&page=${idx }"
																class="page-link" style="color: #C2A18A">${idx }</a></li>
														</c:when>

														<c:otherwise>
															<li class="page-number"><a
																href="${root }notice_list?notice_type=${notice_type}&page=${idx }"
																class="page-link" style="color: black">${idx }</a></li>
														</c:otherwise>
													</c:choose>
												</c:forEach>


														

												<!-- 다음 버튼 -->
												<c:choose>
													<c:when test="${pageBean.max >= pageBean.pageCnt }">
														<li class="page-number disabled">
															<!-- ★★★★[css 요청] 비활성화 --> <a href="#" class="page-link"
															style="color: gray">></a>
														</li>
													  </c:when>
												    <c:otherwise>
														
														
														<li class="page-number"><a
															href="${root }notice_list?notice_type=${notice_type}&page=${pageBean.nextPage}"
															class="page-link" style="color: black">></a></li>
													</c:otherwise>
												</c:choose>

											</ul>
										</nav>
									</div>
														<c:choose>
															<c:when test="${admin_idx == 1 && loginUserBean.userLogin == true}">
																<a class="btn-theme btn-black"
																	href="${root }notice_write?notice_type=${notice_type}">글쓰기</a>
															</c:when>
														</c:choose>
								</div>
							</div>
						</div>
					</div>
					<div></div>
					<div class="action-top">
						<div class="pro-qty-area"></div>
					</div>
				</div>
			</section>

			<!--== End Blog Area Wrapper ==-->
		</main>


		<!-- 하단 footer -->
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
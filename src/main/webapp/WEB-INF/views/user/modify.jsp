<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

  
  function sample6_execDaumPostcode() {
      new daum.Postcode({
          oncomplete: function(data) {
              // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.

              // ??? ????????? ?????? ????????? ?????? ????????? ????????????.
              // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
              var addr = ''; // ?????? ??????
              var extraAddr = ''; // ???????????? ??????

              //???????????? ????????? ?????? ????????? ?????? ?????? ?????? ?????? ????????????.
              if (data.userSelectedType === 'R') { // ???????????? ????????? ????????? ???????????? ??????
                  addr = data.roadAddress;
              } else { // ???????????? ?????? ????????? ???????????? ??????(J)
                  addr = data.jibunAddress;
              }

              // ???????????? ????????? ????????? ????????? ???????????? ??????????????? ????????????.
              if(data.userSelectedType === 'R'){
                  // ??????????????? ?????? ?????? ????????????. (???????????? ??????)
                  // ???????????? ?????? ????????? ????????? "???/???/???"??? ?????????.
                  if(data.bname !== '' && /[???|???|???]$/g.test(data.bname)){
                      extraAddr += data.bname;
                  }
                  // ???????????? ??????, ??????????????? ?????? ????????????.
                  if(data.buildingName !== '' && data.apartment === 'Y'){
                      extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                  }
                  // ????????? ??????????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.
                  if(extraAddr !== ''){
                      extraAddr = ' (' + extraAddr + ')';
                  }
                  // ????????? ??????????????? ?????? ????????? ?????????.
                  document.getElementById("sample6_extraAddress").value = extraAddr;
              
              } else {
                  document.getElementById("sample6_extraAddress").value = '';
              }

              // ??????????????? ?????? ????????? ?????? ????????? ?????????.
              document.getElementById('sample6_postcode').value = data.zonecode;
              document.getElementById("sample6_address").value = addr;
              // ????????? ???????????? ????????? ????????????.
              document.getElementById("sample6_detailAddress").focus();
          }
      }).open();
  }
</script>

<body>

<!--wrapper start-->
<div class="wrapper">

  <c:import url="/WEB-INF/views/include/top_menu.jsp"/>
  
  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-overlay-black2-6 bg-img" data-bg-img="assets/img/photos/bg-page2.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title">????????????</h2>
              <div class="bread-crumbs"><a href="${root}main">Home<span class="breadcrumb-sep"></span></a><span class="active">Delete</span></div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--== End Page Title Area ==-->

    <!--== Start Contact Area ==-->
    <div class="account-login-area">
      <div class="container">
        <div class="row">
          <div class="col-lg-7 m-auto">
            <div class="login-bottom">
                  <div class="login-form">
          <form:form class="login-form-wrapper" action="${root }user_modify_pro" method="post" modelAttribute="modifyUserBean">                  
                      <div class="row">
                        <div class="col-lg-12">
                            <div class="col-md-12">
                             <div class="col-md-12" style="text-align:right">
                              <div class="form-group mb-0 form-group-info">
                                <a class="btn-forgot" href="${root}delete?user_idx=${user_idx}">????????????</a>
                              </div>
                              <div class="form-group" align="left">
                                <label for="user_name" class="form-label" >Name *</label>
                                <form:input class="form-control" path="user_name" readonly="true"/>
                              </div>
                            </div>
                            <div class="col-md-12">
                              <div class="form-group">
                                <label for="user_id" class="form-label">ID *</label>
                                <div class="input-group">
                                  <form:input class="form-control" path="user_id" readonly="true"/>
                                  <div class="input-group-append">
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="col-md-12">
                              <div class="form-group mb-0">
                                <label for="user_pw" class="form-label mt-15">Password *</label>
                                <form:password class="form-control" path="user_pw" />
                                <form:errors path="user_pw" style='color:red'/>
                              </div>
                            </div>
                            
                            <div class="col-md-12">
                              <div class="form-group mb-0">
                                <label for="user_pw2" class="form-label mt-15">Password Confirm *</label>
                                <form:password class="form-control" path="user_pw2"/>
                                <form:errors path="user_pw2" style='color:red'/>
                              </div>
                            </div>
                            <div class="col-md-12">
                              <div class="form-group mb-0">
                                <label for="user_email" class="form-label mt-15">Phone *</label>
                                <form:input class="form-control" path="user_phone" />
                              </div>
                            </div>
                            <div class="col-md-12">
                              <div class="form-group mb-0">
                                <label for="user_email" class="form-label mt-15">Email *</label>
                                <form:input class="form-control" path="user_email" />
                              </div>
                            </div>
                            <div class="col-md-12">
                              <div class="form-group mb-0">
                                <label for="user_email" class="form-label mt-15">Address *</label><br />
                                <div>
                                  <form:input path="sample6_postcode" readonly="true"/>
                          <input type="button" class="btn-post-code" onclick="sample6_execDaumPostcode()" value="???????????? ??????"/><br>
                          <div style="margin-top:10px">
                            <form:input path="sample6_address" readonly="true"/>
                            <form:input path="sample6_detailAddress" readonly="true"/>
                            <form:input path="sample6_extraAddress" readonly="true"/>
                          </div> <br />                    
                        </div>
                              </div>
                            </div>
                            <p />
                            <p />
                            <div class="col-md-12">
                              <div class="form-group mb-0 form-group-info" style="text-align:center">
                                <form:button class="btn btn-theme btn-black" style="margin-top:10px">????????????</form:button>
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
    <!--== End Contact Area ==-->
  </main>

  <c:import url="/WEB-INF/views/include/bottom_info.jsp"/>
  
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="en">

<head>

<!-- kakao api -->
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.0/kakao.min.js"
  integrity="sha384-PFHeU/4gvSH8kpvhrigAPfZGBDPs372JceJq3jAXce11bVA6rMvGWzvP4fMQuBGL" crossorigin="anonymous"></script>
<script>
  Kakao.init('82d2895877c0cf0d28eec7bc67f9e05d'); // 사용하려는 앱의 JavaScript 키 입력
</script>
<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:9987/LED_COLURR/join',
      state: 'userme',
    });
  }

  function requestUserInfo() {
    Kakao.API.request({
      url: '/v2/user/me',
    })
      .then(function(res) {
        alert(JSON.stringify(res));
      })
      .catch(function(err) {
        alert(
          'failed to request user information: ' + JSON.stringify(err)
        );
      });
  }

  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      document.querySelector('#token-result').innerText = 'login success, ready to request API';
      document.querySelector('button.api-btn').style.visibility = 'visible';
    }
  }

  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  }
  
</script>


<!-- 카카오 코드 끝 --> 
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
<div class="wrapper">

  <c:import url="/WEB-INF/views/include/top_menu.jsp"/>
  
  <main class="main-content">
    <!--== Start Page Title Area ==-->
    <section class="page-title-area bg-overlay-black2-6 bg-img" data-bg-img="assets/img/photos/bg-page2.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-title-content">
              <h2 class="title">My Account</h2>
              <div class="bread-crumbs"><a href="index.html">Home<span class="breadcrumb-sep">></span></a><span class="active">Login</span></div>
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
                    <form:form class="login-form-wrapper" action="${root }login_pro" method="post" modelAttribute="tempLoginUserBean">
                      <div class="row">
                        <div class="col-lg-12">
                          <div class="row">
                            <div class="col-md-12" style="text-align:right">
                              <div class="form-group mb-0 form-group-info">
                                <a class="btn-forgot" href="${root}join">Register</a>
                              </div>
                            </div>
                            <div class="col-md-12">
                              <div class="form-group">
                                <label for="UserName" class="form-label">ID *</label>
                                <input type="text" class="form-control" id="UserName" name="user_id">
                                <form:errors path="user_id" style='color:red'/>
                              </div>
                            </div>
                            <div class="col-md-12">
                              <div class="form-group mb-0">
                                <label for="password" class="form-label mt-15">Password *</label>
                                <input type="password" class="form-control" id="password" name="user_pw">
                                <form:errors path="user_pw" style='color:red'/>
                              </div>
                            </div>
                            <div class="col-md-12" style="text-align:center">
                              <div class="form-group mb-0 form-group-info">
                                <button class="btn btn-theme btn-black" type="submit" style="margin:20px">Log in</button><br />
                                <a class="btn-forgot" href="#" style="text-align:left">Lost your password?</a><br>
                        
                        <!-- 네이버 로그인 영역 시작 -->



<div id="naver_id_login"></div>
<script type="text/javascript"
      src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
      charset="utf-8"></script>

<script type="text/javascript">
      var clientId = "lO7A3a3XAiVKMdaA3_CC "; //클라이언트 ID 넣기 
      var callbackUrl = "http://localhost:9987/LED_COLURR/join"; // 콜백 URL 넣기
      var naver_id_login = new naver_id_login(clientId, callbackUrl);
      var state = naver_id_login.getUniqState();
      naver_id_login.setButton("white", 3, 40);
      naver_id_login.setDomain("http://localhost:9987");
      naver_id_login.setState(state);
      naver_id_login.init_naver_id_login();
</script>

 <a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
    alt="카카오 로그인 버튼" /></a>
    <!-- kakao -->
<button class="api-btn" onclick="requestUserInfo()" style="visibility:hidden">사용자 정보 가져오기</button>



                        
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
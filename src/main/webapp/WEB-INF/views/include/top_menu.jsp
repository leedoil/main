<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="en">
<body>
  
  
  <!--== Start Header Wrapper ==-->
  <header class="header-area header-default sticky-header">
    <div class="container-fluid">
      <div class="row row-gutter-0 align-items-center">
        <div class="col-4 col-xs-3 col-sm-3 col-md-3 col-xl-2 col-xxl-3">
          <div class="header-logo-area">
            <a href="${root }main">
              <img class="logo-main" src="assets/img/logo-main.png" alt="Logo" width="280"  />
              <img class="logo-light" src="assets/img/logo-main.png" alt="Logo"  />
            </a>
          </div>
        </div>
        <div class="col-md-7 col-xl-7 col-xxl-6 d-none d-xl-block">
          <div class="header-align">
            <div class="header-navigation-area">
              <ul class="main-menu nav justify-content-center position-relative">
                <li><a href="${root}main" style="font-size:28px;">About</a></li>
                <li class="has-submenu"><a href="${root}product_list?product_gender=Men" style="font-size:28px;">Men</a>
                  <ul class="submenu-nav">
                    <li><a href="${root}product_type_list?product_gender=Men&product_colortype=Spring_Warm">Spring Warm</a></li>
                    <li><a href="${root}product_type_list?product_gender=Men&product_colortype=Summer_Cool">Summer Cool</a></li>
                    <li><a href="${root}product_type_list?product_gender=Men&product_colortype=Autumn_Warm">Autumn Warm</a></li>
                    <li><a href="${root}product_type_list?product_gender=Men&product_colortype=Winter_Cool">Winter Cool</a></li>
                  </ul>
                </li>
                <li class="has-submenu"><a href="${root}product_list?product_gender=Women" style="font-size:28px;">Women</a>
                  <ul class="submenu-nav">
                    <li><a href="${root}product_type_list?product_gender=Women&product_colortype=Spring_Warm">Spring Warm</a></li>
                    <li><a href="${root}product_type_list?product_gender=Women&product_colortype=Summer_Cool">Summer Cool</a></li>
                    <li><a href="${root}product_type_list?product_gender=Women&product_colortype=Autumn_Warm">Autumn Warm</a></li>
                    <li><a href="${root}product_type_list?product_gender=Women&product_colortype=Winter_Cool">Winter Cool</a></li>
                  </ul>
                </li>
                <li class="has-submenu"><a href="#none" style="font-size:28px;" >Notice</a>
                  <ul class="submenu-nav">
                    <li><a href="${root }notice_list?notice_type=notice">Notice</a></li>
                    <li><a href="${root }notice_list?notice_type=event">Event</a></li>
                  </ul>
                </li>
                <c:choose>
                  <c:when test="${loginUserBean.user_idx == 1 && loginUserBean.userLogin == true }">
                    <li class="has-submenu"><a href="#none" style="font-size:28px;">Admin</a>
                      <ul class="submenu-nav">
                        <li><a href="${root }admin_userlist">User List</a></li>
                        <li><a href="${root }admin_productlist">Product List</a></li>
                        <li><a href="${root }admin_qnalist">Q&A List</a></li>
                      </ul>
                    </li>
                  </c:when>
                </c:choose>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-8 col-xs-9 col-sm-9 col-md-9 col-xl-3 col-xxl-3">
          <div class="header-action-area">
            <div class="header-action-search">
              <button class="btn-search btn-search-menu">
                <i class="lastudioicon-zoom-1"></i>
              </button>
            </div>
            <div class="header-action-login">
              <c:choose>
                <c:when test="${loginUserBean.userLogin == true }">
                   <button class="btn-login" onclick="location.href='${root}mypage'">
                      <i class="lastudioicon-single-01-2"></i>
                  </button>
                </c:when>
                <c:otherwise>
                  <button class="btn-login" onclick="location.href='${root}login'">
                    <i class="lastudioicon-single-01-2"></i>
                  </button>
                </c:otherwise>
              </c:choose>
            </div>
            <div>
              <button class="btn-cart cart-icon" onclick="location.href='${root}cart'">
                <i class="lastudioicon-shopping-cart-2"></i>
              </button>
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <div class="header-action-account d-none d-xxl-block">
              <c:choose>
                <c:when test="${loginUserBean.userLogin == true }">
                  <div class="header-action-account d-none d-xxl-block">
                    <a href="${root}logout"  style="font-size:25px; color:#B98CFF; font-weight:bold; ">Sign Out</a>
                  </div>
                </c:when>
              <c:otherwise>
                <div class="header-action-account d-none d-xxl-block">
                   <a href="${root}join" style="font-size:25px; color:#B98CFF; font-weight: bold; ">Sign Up</a>
                 </div>
               </c:otherwise>
           </c:choose>
         </div>
            <button class="btn-menu d-xl-none">
              <i class="lastudioicon-menu-3-1"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!--== End Header Wrapper ==-->
  

</body>
</html>
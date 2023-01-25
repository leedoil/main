<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COLURR</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
   rel="stylesheet">
<link rel="stylesheet"
   href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   


<style>

footer p a span {
    color: #FF9F46;
    font-size: 10px;
    letter-spacing: 1px;
    font-weight: 700;
}

body {
   color: #566787;
   background: #ffffff;
   font-family: 'Roboto', sans-serif;
}

.table-responsive {
   margin: 30px 0;
}

.table-wrapper {
   min-width: 1000px;
   background: #fff;
   padding: 20px;
   box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
   padding-bottom: 10px;
   margin: 0 0 10px;
}

.table-title h2 {
   margin: 8px 0 0;
   font-size: 22px;
}

.search-box {
   position: relative;
   float: right;
}

.search-box input {
   height: 34px;
   border-radius: 20px;
   padding-left: 35px;
   border-color: #ddd;
   box-shadow: none;
}

.search-box input:focus {
   border-color: #3FBAE4;
}

.search-box i {
   color: #a0a5b1;
   position: absolute;
   font-size: 19px;
   top: 8px;
   left: 10px;
}

table.table tr th, table.table tr td {
   border-color: #e9e9e9;
}

table.table-striped tbody tr:nth-of-type(odd) {
   background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
   background: #f5f5f5;
}

table.table th i {
   font-size: 13px;
   margin: 0 5px;
   cursor: pointer;
}

table.table td:last-child {
   width: 130px;
}

table.table td a {
   color: #a0a5b1;
   display: inline-block;
   margin: 0 5px;
}

table.table td a.view {
   color: #03A9F4;
}

table.table td a.edit {
   color: #FFC107;
}

table.table td a.delete {
   color: #E34724;
}

table.table td i {
   font-size: 19px;
}

.pagination {
   float: right;
   margin: 0 0 5px;
}

.pagination li a {
   border: none;
   font-size: 95%;
   width: 30px;
   height: 30px;
   color: #999;
   margin: 0 2px;
   line-height: 30px;
   border-radius: 30px !important;
   text-align: center;
   padding: 0;
}

.pagination li a:hover {
   color: #666;
}

.pagination li.active a {
   background: #03A9F4;
}

.pagination li.active a:hover {
   background: #0397d6;
}

.pagination li.disabled i {
   color: #ccc;
}

.pagination li i {
   font-size: 16px;
   padding-top: 6px
}

.hint-text {
   float: left;
   margin-top: 6px;
   font-size: 95%;
}

.status {
   font-size: 30px;
   margin: 2px 2px 0 0;
   display: inline-block;
   vertical-align: middle;
   line-height: 10px;
}

.text-success {
   color: #10c469;
}

.text-danger {
   color: #ff5b5b;
}

a:link {
   text-decoration: none;
   color: #566787;
}

.justify-content-center {
   -ms-flex-pack: center !important;
   justify-content: center !important;
}
</style>
<script>
   
</script>
</head>
<body>

   <div class="container">
      <div class="table-responsive">
         <div class="table-wrapper">
            <div class="table-title">
               <div class="row">
                  <div class="col-sm-8">
                     <h3>
                        Product <b>Details</b>
                     </h3>
                  </div>
                  <div class="col-sm-8">상품 관리</div>
                  <div class="col-sm-4">
                     <div class="search-box">
                        
                     </div>
                  </div>
               </div>
            </div>
               <h4>
                  <a href="${root }main" style="color:red"> Main으로 이동 </a> <br />
               </h4>
           		 전체 다시 불러오기 : 
           		 <a href="${root}admin_productlist" class="replace" title="Replace" data-toggle="tooltip"><i class="material-icons">cached</i></a>
            <div>
               <table class="table table-striped table-hover table-bordered">
                  <thead>
                     <tr>
                        <th>Idx</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Stock</th>
                        
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="obj" items="${productlist }" >
                        <tr>
                           <td>${obj.product_idx }</td>
                           <td>${obj.product_name }</td>
                           <td style="width: 30%">
                             <form:form method="post" action="${root}changePrice" modelAttribute="changeProduct">
							   <input type="hidden" name="product_idx" value="${obj.product_idx}">
                               <input type="number" name="product_price" id="product_price" value="${obj.product_price }" >
                               <button type="submit" style="width:30px; height:20px; font-size:10px; border:none; border-radius:5px; background-color:#d6cab8">OK</button>
                             </form:form>
                           </td>
                           <td style="width: 30%">
							  <form:form method="post" action="${root}changeStock" modelAttribute="changeProduct">
							   <input type="hidden" name="product_idx" value="${obj.product_idx}">
                               <input type="number" name="product_instock" id="product_instock" value="${obj.product_instock }" >
                               <button type="submit" style="width:30px; height:20px; font-size:10px; border:none; border-radius:5px; background-color:#d6cab8">OK</button>
                             </form:form>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
            </div> 
		</div>
      </div>
   </div>
   <!-- footer  -->
   
</body>
</html>
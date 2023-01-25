<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>	

<script>
	alert('작성완료')
	location.href='${root}notice_read?notice_type=${writeNoticeBean.notice_type}&notice_idx=${writeNoticeBean.notice_idx}'
</script>
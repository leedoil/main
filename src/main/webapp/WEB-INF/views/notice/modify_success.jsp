<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 절대경로 설정 -->
<c:set var='root' value="${pageContext.request.contextPath}/"/>	

<script>
	alert('수정완료')
	location.href='${root}notice_read?notice_type=${modifyNoticeBean.notice_type}&notice_idx=${modifyNoticeBean.notice_idx}&page=${page}'
</script>
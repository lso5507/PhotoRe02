<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="/photo/resources/css/top_menu.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="top">
	 
		<a href="/photo/" id="top_index" >Album</a>
	
	<div class="dropdown">
	  <p>Menu</p>
	  <div class="dropdown-content">
			<c:if test="${empty member}">
				<a href="${cp}/photo/joinForm">JOIN</a> &nbsp;&nbsp; 
				<a href="${cp}/photo/loginForm">LOGIN</a> &nbsp;&nbsp; 
			</c:if>
			<c:if test="${!empty member}">
				<a href="${cp}/photo/idModifyForm">ID_MODIFIY</a> &nbsp;&nbsp; 
				<a href="${cp}/photo/pwModifyForm">PW_MODIFY</a> &nbsp;&nbsp; 
				<a href="${cp}/photo/remove">REMOVE</a> &nbsp;&nbsp; 
				<a href="${cp}/photo/logout">LOGOUT</a> &nbsp;&nbsp; 
			</c:if>
	  </div>
	</div>
</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Home
</h1>
	<c:if test="${empty member}">
		${serverTime}<br>
		<a href="${cp}/photo/joinForm">JOIN</a> &nbsp;&nbsp; 
		<a href="${cp}/photo/loginForm">LOGIN</a> &nbsp;&nbsp; 
	</c:if>
	
	<c:if test="${!empty member}">
		${serverTime}<br>
		<a href="${cp}/photo/idModifyForm">Id_Modify</a> &nbsp;&nbsp; 
		<a href="${cp}/photo/pwModifyForm">Pw_Modify</a> &nbsp;&nbsp; 
		<a href="${cp}/photo/logout">LOGOUT</a> &nbsp;&nbsp;
		<a href="${cp}/photo/remove">REMOVE</a> &nbsp;&nbsp; 
	</c:if>
	
</body>
</html>

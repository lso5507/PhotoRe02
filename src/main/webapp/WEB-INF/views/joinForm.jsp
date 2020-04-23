<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/normal.css" />
</head>
<body>
<form action="join" method="post">
<table class="loginForm">
	<tr>
		<td id="text">ID</td> <td> <input type="text" name="memId"> </td>
	</tr>
	<tr>
		<td id="text">PASSWORD </td> <td><input type="password" name="memPw"></td>
	</tr>

</table>
	<input type="submit" value="join">
	<input type="button" value="back" onclick="history.back()">
	<a href="/photo/">Home</a><br>
	<a href="/photo/loginForm" ></a>Login
</form>
</body>
</html>

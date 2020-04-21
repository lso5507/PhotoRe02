<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/normal.css" />
</head>
<body>
<form action="modify" method="post">
<table class="loginForm">
	<tr>
		<td id="text">ID</td> <td> <input type="text" name="memId"> </td>
	</tr>
	<tr>
		<td id="text">PASSWORD </td> <td><input type="text" name="memPw"></td>
	</tr>
</table>
	<input type="submit" value="login">
	<input type="button" value="back" onclick="history.back()">
</form>
</body>
</html>
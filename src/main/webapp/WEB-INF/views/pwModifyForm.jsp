<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
<form action="pwModify" method="post">
<table class="loginForm">
	<tr>
		<td id="text">ID</td> <td> ${member.getMemId()} </td>
	</tr>
	<tr>
		<td id="text">PASSWORD </td> <td><input type="password" name="memPw"></td>
	</tr>
	<tr>
		<td id="text">REPASSWORD </td> <td><input type="password" name="reMemPw"></td>
	</tr>
</table>
	<input type="submit" value="Modify">

</form>

	
</body>
</html>
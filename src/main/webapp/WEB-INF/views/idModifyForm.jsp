<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
<form action="idModify" method="post">
<table class="loginForm">
	<tr>	
		<td id="text">ID</td> <td> <input type="text" name="memId"> </td>
	</tr>
	<tr>
		<td id="text">RE_ID</td> <td> <input type="text" name="reMemId"> </td>
	</tr>
	<tr>
		<td id="text">PASSWORD </td> <td>*******</td>
	</tr>
</table>
	<input type="submit" value="Modify">
	<input type="button" value="back" onclick="history.back()">
</form>

	
</body>
</html>
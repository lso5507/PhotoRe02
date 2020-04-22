<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/normal.css" />
</head>
<body>
<h1>Login Success</h1>
<h2>ID :${member.getmemId()} </h2>
<h2>PASSWORD :${member.getMemPw()} </h2>

</body>
</html>

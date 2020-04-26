<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
html{
	background-image: url(/photo/resources/repository/forest_gray.jpg);
		

		background-repeat : no-repeat;

		background-size : cover;
		
		
		
		


	
}
html,body{
height: 100%;}
#left{
float:left;
width:25%;
height: 100%;


}
.container{
float:left;
height: 100%;
width:50%;
background-color: #a9a6a6;

}
#right{
float:left;
width:25%;
height: 100%;
}
#con{
	padding-left:25%;
	
	padding-right:25%;
}
#con form{
	padding-top:20px;
}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
<tiles:insertAttribute name="head" />
</head>
<body>	
<div id="left">　</div>
        <div class="container">
        	<div id="con">
            <tiles:insertAttribute name="content" />
            </div>
        </div>
<div id="right">　</div>
</body>
</html>
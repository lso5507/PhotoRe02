<%@page import="javax.swing.text.html.HTMLWriter"%>
<%@page import="javax.swing.text.html.HTML"%>
<%@page import="pjt.lw.Member.Member"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.mysql.cj.Session"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 


<html>



<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        
        <script src="/photo/resources/js/sc.js"></script> 

</head>
<body>

	<c:if test="${empty member}">
<link href="/photo/resources/css/cover.css" rel="stylesheet" type="text/css">			
<div class="body">
	<div class="scene">
	  <div class="page page-1 ">
	    <div class="half left"></div>
	    <div class="half right withText">
	      <h2 class="heading">Page 1</h2>
	    </div>
	  </div>
	  <div class="page page-2">
	    <div class="half left withText">
	      <h2 class="heading">Page 2</h2>
	    </div>
	    <div class="half right"></div>
	  </div>
	  <div class="page page-3">
	    <div class="half left"></div>
	    <div class="half right withText">
	      <h2 class="heading">Page 3</h2>
	    </div>
	  </div>
	  <div class="page page-4">
	    <div class="half left withText">
	      <h2 class="heading">Page 4</h2>
	    </div>
	    <div class="half right"></div>
	  </div>
	  <div class="page page-5">
	    <div class="half left withText">
	      <h2 class="heading">Page 5</h2>
	    </div>
	    <div class="half right"></div>
	  </div>
	</div>
	<div class="nav-panel">
	  <div class="scroll-btn up"></div>
	  <div class="scroll-btn down"></div>
	  <nav>
	    <ul>
	      <li data-target="1" class="nav-btn nav-page1 active"></li>
	      <li data-target="2" class="nav-btn nav-page2"></li>
	      <li data-target="3" class="nav-btn nav-page3"></li>
	      <li data-target="4" class="nav-btn nav-page4"></li>
	      <li data-target="5" class="nav-btn nav-page5"></li>
	    </ul>
	  </nav>
	</div>
        
</div>	
	</c:if>
	
     <c:if test="${!empty member}">
     
<link href="/photo/resources/css/cover_member.css" rel="stylesheet" type="text/css">			
<div class="body">	
	<div class="scene">
	  <div class="page page-1 active">
	    <div class="half left">
	    	<img src="/image/"/>
	    </div>
	    <div class="half right"></div>
	  </div>
	  <div class="page page-2">
	    <div class="half left"></div>
	    <div class="half right"></div>
	  </div>
	</div>
	<div class="nav-panel">
	  <div class="scroll-btn up"></div>
	  <div class="scroll-btn down"></div>
	  <nav>
	    <ul class="nav_img">
	      <li data-target="1" class="nav-btn nav-page1 active"></li>
	      <li data-target="2" class="nav-btn nav-page2"></li>
	      <li data-target="3" class="nav-btn nav-page3"></li>
	      <li data-target="4" class="nav-btn nav-page4"></li>
	      <li data-target="5" class="nav-btn nav-page5"></li>
	    </ul>
	  </nav>
	</div>
        
 	
        <script type="text/javascript">
        	var ele=document.getElementsByClassName('half')
        	var imgUrl="${mem.getImgUrl()}";
        	var img = new Image();

      		
			 imgArray = imgUrl.split(",");
			alert(imgArray[0]+"테스트입니다.");
        	for(let i=0; i<imgArray.length; i+=2){
        		
				img.src="<spring:url value='/image/"+imgArray[i]+".png'/>";
				
				ele[i].append(img);
        	}
        	
        //	$('.page:nth-child(1) .left').css('background-image', 'url(' + 'http://i.imgur.com/KEnImct.jpg' + ')');
        	
        	
        		
     	</script>


</div>	
	</c:if>   



</body>
</html>

<%@page import="javax.swing.text.html.HTMLWriter"%>
<%@page import="javax.swing.text.html.HTML"%>
<%@page import="pjt.lw.Member.Member"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.mysql.cj.Session"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<html>



<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <link href="/photo/resources/css/cover.css" rel="stylesheet" type="text/css">
        <script src="/photo/resources/js/sc.js"></script> 

</head>
<body>

	<c:if test="${empty member}">
			
<div class="body">
	<div class="scene">
	  <div class="page page-1 active">
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

<div class="body">	
	<div class="scene">
	-
		<c:forEach items="${member.imgUrl}" var="url">
		
			<div class="half left"><img src="${pageContext.request.contextPath}/resources/image/${url}"></div>
			<div class="half right"></div>
		
		</c:forEach>
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
        
 
        <script type="text/javascript">
        $(function(){
			var divEle=document.getElementsByClassName("scene");
			var url =
        });			
     	</script>


</div>	
	</c:if>   



</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<link href="/photo/resources/css/cover.css" rel="stylesheet" type="text/css">
<head>


	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

        <link href="/photo/resources/boot/css/styles.css" rel="stylesheet" />
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="/photo/resources/js/sc.js"></script> 

</head>
<body>
  
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Never expand</a>
  <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarsExample01" aria-controls="navbarsExample01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-collapse collapse" id="navbarsExample01" style="">
    <ul class="navbar-nav mr-auto">
    <c:if test="${empty member}">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
	</c:if>
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
	    </ul>
	  </nav>
	</div>
        

	
</body>
</html>

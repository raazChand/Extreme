<!DOCTYPE html>
<html lang="en">

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
  
  <title>Index page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      
      <div class="item active">
        <img src="<spring:url value="/resources/Images/1.jpg.jpg/"/>" alt="Image">
       <div class="carousel-caption">
       </div>
       </div>

      <div class="item">
        <img src="<spring:url value="/resources/Images/2.jpg.jpg/"/>"  alt="Image" >
        <div class="carousel-caption">
       </div>
        </div>
          
      <div class="item">
        <img src="<spring:url value="/resources/Images/3.jpg.jpg/"/>"  alt="Image" >
        <div class="carousel-caption">
       </div>
        </div>
	
	 <div class="item">
        <img src="<spring:url value="/resources/Images/4.jpg.jpg/"/>"  alt="Image" >
        <div class="carousel-caption">
       </div>
        </div>
        
      <div class="item">
        <img src="<spring:url value="/resources/Images/5.jpg.jpg/"/>"  alt="Image" >
       <div class="carousel-caption">
       </div>
        </div>
        
       <div class="item">
        <img src="<spring:url value="/resources/Images/6.jpg.jpg/"/>"  alt="Image" >
        <div class="carousel-caption">
       </div>
        </div> 
       
         <div class="item">
        <img src="<spring:url value="/resources/Images/7.jpg.jpg/"/>"  alt="Image" >
        <div class="carousel-caption">
       </div>
        </div> 
        
          <div class="item">
        <img src="<spring:url value="/resources/Images/8.jpg.jpg/"/>"  alt="Image" >
        <div class="carousel-caption">
       </div>
        </div>
          
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
</div>

<%@ include file="NavBar.jsp" %>

<%@ include file="Footer.jsp" %>

</body>
</html>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<c:if test="${!sessionScope.loggedIn}">
					<ul class="nav navbar-nav">
						<li class="active"><a href="home">Home</a></li>
						<!--         <li><a href="category">Category</a></li> -->
						<!--         <li><a href="product">Products</a></li> -->
						<!--         <li><a href="supplier">Supplier</a></li> -->
						<li><a href="contactUs">Contact Us</a></li>
						<li><a href="aboutUs">About Us</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="login"><span
								class="glyphicon glyphicon-user"></span> Your Account</a></li>
						<li><a href="signUp">Sign Up</a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
					</ul>
				</c:if>

				<c:if test="${sessionScope.loggedIn}">
					<c:if test="${sessionScope.role=='ROLE_USER'}">
						<ul class="nav navbar-nav">
							<li class="active"><a href="home">Home</a></li>
							<!--         <li><a href="category">Category</a></li> -->
							<!--         <li><a href="product">Products</a></li> -->
							<!--         <li><a href="supplier">Supplier</a></li> -->
							<li><a href="contactUs">Contact Us</a></li>
							<li><a href="aboutUs">About Us</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<!--         <li><a href="login"><span class="glyphicon glyphicon-user"></span> Your Account</a></li> -->
							<li><a href="logout">Logout</a></li>
							<li><a href="#"><span
									class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
						</ul>
					</c:if>

					<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
						<ul class="nav navbar-nav">
							<li class="active"><a href="home">Home</a></li>
							<li><a href="category">Category</a></li>
							<li><a href="product">Products</a></li>
							<li><a href="supplier">Supplier</a></li>
							<li><a href="contactUs">Contact Us</a></li>
							<li><a href="aboutUs">About Us</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
<!-- 							<li><a href="login"><span -->
<!-- 									class="glyphicon glyphicon-user"></span> Your Account</a></li> -->
							<li><a href="logout">Logout</a></li>
							<li><a href="#"><span
									class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
						</ul>
					</c:if>
				</c:if>
			</div>
		</div>
	</nav>

</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
</head>
<body>
<%@include file="NavBar.jsp" %>
<h1>Need To Create an Account ????</h1>

<form:form modelAttribute="user" class="form-horizontal" action="addUser" method="post" >
  <div class="form-group">
    <label class="control-label col-sm-2" for="UserName">UserName:</label>
    <div class="col-sm-5">
      <form:input path="username" type="text" class="form-control" placeholder="user Name" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Customer Name">Customer Name:</label>
    <div class="col-sm-5"> 
      <form:input path="customerName" type="text" class="form-control" placeholder="Enter Your Full Name" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="customerAddress">Address:</label>
    <div class="col-sm-5">
      <form:input path="customerAddress" type="text" class="form-control" placeholder="Address" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="mobile">Mobile:</label>
    <div class="col-sm-5">
      <form:input path="mobile" type="number" class="form-control" placeholder="Nunber" />
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email ID:</label>
    <div class="col-sm-5">
       <form:input path="email" type="text" class="form-control" placeholder="Email" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="role">Role:</label>
    <div class="col-sm-5">
      <form:input type="text" path="role" class="form-control" placeholder="Role as ROLE_USER or ADMIN_USER"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="password">Password:</label>
    <div class="col-sm-5">
       <form:input path="password" type="text" class="form-control" placeholder="password" />
    </div>
  </div>
  			
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form:form>


<%@include file="Footer.jsp" %>
</body>
</html>
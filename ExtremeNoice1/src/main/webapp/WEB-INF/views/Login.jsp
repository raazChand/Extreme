<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%@include file="NavBar.jsp" %>

<h1>Sign In</h1>
<form class="form-horizontal" action="signIn" method="post">
    <div class="form-group">
    <label class="control-label col-sm-2" for="UserName">User Name:</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="username" name="username"  placeholder="user Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Category Description">Password:</label>
    <div class="col-sm-3"> 
      <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      </div>
    </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>

<%@include file="Footer.jsp" %>
</body>
</html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>category</title>

 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="NavBar.jsp" %>

<h2 align="center">Category page</h2>

<form class="form-horizontal" action="addCategory" method="post">
    <div class="form-group">
    <label class="control-label col-sm-2" for="Category Name">Category Name:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="catname" name="catname"  placeholder="Category Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Category Description">Category Description:</label>
    <div class="col-sm-5"> 
      <input type="text" class="form-control" id="catdesc" name="catdesc" placeholder="Enter Category Description">
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
<table class="table">
    <thead>
      <tr>
        <th>CategoryId</th>
        <th>CategoryName</th>
        <th>CategoryDescription</th>
        <th>Operation</th>
      </tr>
    </thead>
    <c:forEach items="${categorylist}" var="category">
    <tbody>
      <tr>
        <td>${category.categoryId}</td>
        <td>${category.categoryName}</td>
        <td>${category.categoryDesc}</td>
        <td>
        	<a href="<c:url value='EditCategory,${category.categoryId}'/>">Edit</a>/
			<a href="<c:url value='DeleteCategory,${category.categoryId}'/>">Delete</a>/
        </td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
<%@ include file="Footer.jsp" %>
</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>

 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Product page.</h2>

<form:form modelAttribute="product" class="form-horizontal" action="UpdateProduct" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="Product Id">Product Id:</label>
    <div class="col-sm-5">
      <form:input path="productId" type="text" class="form-control" value="${productInfo.productId}" placeholder="Product Name" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Product Name">Product Name:</label>
    <div class="col-sm-5">
      <form:input path="productName" type="text" class="form-control" value="${productInfo.productName}" placeholder="Product Name" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Product Description">Product Description:</label>
    <div class="col-sm-5"> 
      <form:input path="productDesc" type="text" class="form-control" value="${productInfo.productDesc}" placeholder="Enter Product Description" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Product Price">Price:</label>
    <div class="col-sm-5">
      <form:input path="price" type="text" class="form-control" value="${productInfo.price}" placeholder="Product Price" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Category Id">Category Id:</label>
    <div class="col-sm-5">
       <form:select path="categoryId" type="number" class="form-control">
      <form:option value="${productInfo.categoryId}"/>
      <form:options items="${categoryList}"/>
      </form:select>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Supplier Id">Supplier Id:</label>
    <div class="col-sm-5">
       <form:select path="supplierId" type="number" class="form-control">
      <form:option value="${productInfo.supplierId}" />
      <form:options items="${supplierList }"/>
      </form:select>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      </div>
    </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Update</button>
    </div>
  </div>
</form:form>

<table class="table">
    <thead>
      <tr>
        <th>ProductId</th>
        <th>ProductName</th>
        <th>ProductDescription</th>
        <th>Price</th>
        <th>CategoryId</th>
        <th>SupplierId</th>
        <th>Operation</th>
      </tr>
    </thead>
    <c:forEach items="${productlist}" var="product">
    <tbody>
      <tr>
        <td>${product.productId}</td>
        <td>${product.productName}</td>
        <td>${product.productDesc}</td>
        <td>${product.price}</td>
        <td>${product.categoryId}</td>
        <td>${product.supplierId}</td>
        <td>
        	<a href="<c:url value='EditProduct,${product.productId}'/>">Edit</a>/
			<a href="<c:url value='DeleteProduct,${product.productId}'/>">Delete</a>/
        </td>
      </tr>
    </tbody>
    </c:forEach>
  </table>

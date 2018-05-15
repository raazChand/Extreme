<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier</title>

 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Supplier page.</h2>

<form class="form-horizontal" action="updateSupplier" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="Supplier Id">Supplier Id:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" readonly id="Sid" name="Sid" value="${supplierInfo.supplierId }" placeholder="Supplier Id">
    </div>
  </div>
<div class="form-group">
    <label class="control-label col-sm-2" for="Supplier Name">Supplier Name:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="Sname" name="Sname" value="${supplierInfo.supplierName }" placeholder="Supplier Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="Supplier Address">Supplier Address:</label>
    <div class="col-sm-5"> 
      <input type="text" class="form-control" id="Saddress" name="Saddress" value="${supplierInfo.supplierAddress }" placeholder="Enter Supplier Address">
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
</form>

<table class="table">
    <thead>
      <tr>
        <th>SupplierId</th>
        <th>SupplierName</th>
        <th>SupplierAddress</th>
        <th>Operation</th>
      </tr>
    </thead>
    <c:forEach items="${supplierlist}" var="supplier">
    <tbody>
      <tr>
        <td>${supplier.supplierId}</td>
        <td>${supplier.supplierName}</td>
        <td>${supplier.supplierAddress}</td>
        
        <td>
        	<a href="<c:url value='EditSupplier,${supplier.supplierId}'/>">Edit</a>/
			<a href="<c:url value='DeleteSupplier,${supplier.supplierId}'/>">Delete</a>
        </td>
      </tr>
    </tbody>
    </c:forEach>
  </table>



</body>
</html>
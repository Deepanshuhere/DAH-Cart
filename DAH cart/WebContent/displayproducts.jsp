<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Products</title>

<!-- BOOTSTRAP -->
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">

    <script src="bootstrap/js/bootstrap.min.js">		 </script>				
    <script src="bootstrap/js/bootstrap.bundle.min.js">	 </script>  		
    <script src="bootstrap/jquery/jquery-3.2.1.min.js">	 </script>  		
    <script src="bootstrap/jquery/popper.min.js">		 </script>  			
    <script src="bootstrap/jquery/bootstrap.min.js">	 </script>  			

<!-- BOOTSTRAP -->

</head>

<body>

<form method="post">
<div class="container" style="padding-top:50px;">

<div class="display-3 text-center fixed" style="padding-bottom:30px;">Product List</div>

<!-- ################################ SORT ################################ -->
<div>

<div>
<button type="button" class="btn btn-secondary" onClick="window.location.href='admin.jsp'">Back</button>

<div class="btn-group float-right" role="group">

<div class="dropdown">
<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
Filter
</button>


<% session.setAttribute("requestFrom","displayproducts.jsp"); %>

	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		<a class="dropdown-item" href="GetAllProducts">All</a>
		<c:forEach items="${categories}" var="category" >
		<div>
		<input type="hidden" name="request_coming" value="displayproducts">
       	<a class="dropdown-item" href="GetProducts?categoryId=${category.id }"> ${category.name}  </a>
		</div>
		</c:forEach >
	</div>
</div>

<div class="dropdown">
<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
Sort By
</button>
	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		<a class="dropdown-item" href="SortProducts?sort='price'">Price</a>
		<a class="dropdown-item" href="SortProducts?sort='name'">Name </a>
	</div>
</div>
</div>
</div>
</div>
<!-- ################################ SORT ################################ -->
<div class="table-wrapper-scroll-y">
<table class="table table-hover table-sm table-striped table-bordered table-responsive" >
  <thead>
    <tr>
      <th scope="col">Image</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Description</th>
      <th scope="col">Operation</th>
    
    </tr>
  </thead>
  <tbody>  
  
  	<c:forEach items="${products}" var="product">
       <tr>
         <td class="col-1"><img src="images/product image/${product.id}.jpg" class="img-responsive" alt="Image not found :/" width="200px" height="100px" > </td>
         <td class="col-3">${product.name}</td>
         <td class="col-1">Rs.${product.price}</td>
		 <td class="col-1">${product.quantity}</td>
       	 <td class="col-3">${product.description}</td>
       	 <td class="col-2">
       	 	<input type="hidden" name="request_coming" value="displayproducts">
       		<input type="submit" formaction="GetProduct?id=${product.id}" class="btn btn-primary btn-sm" value="Update" >
      		<input type="submit" formaction="DeleteProduct?id=${product.id}" class="btn btn-primary btn-sm" value="Delete" >
      	 </td>
       </tr>
     </c:forEach>
   
  </tbody>
</table>
</div>
</div>
</form>

</body>
</html>
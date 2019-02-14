<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<!-- BOOTSTRAP -->
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.min.js"></script>  
        <script src="bootstrap/jquery/jquery-3.2.1.min.js"></script>  			
        <script src="bootstrap/jquery/popper.min.js"></script>  
        <script src="bootstrap/jquery/bootstrap.min.js"></script>  
<!-- BOOTSTRAP -->

</head>
<body>



<div class="container" style="padding-top:70px;">

<div class="card mx-auto" style="width: 40rem;">
  <div class="card-body">
    <h5 class="card-title display-4 text-center">Update Product</h5>

	<form action="UpdateProduct" method="post" >

	   	<input type="hidden" class="form-control form-control-sm" name="id" value="${requestScope.product.id}" > 


	<div class="form-group ">
	   	<label for="name">Category</label>
	   	<input type="text" class="form-control form-control-sm" name="category" value="Men" readonly> 
	</div>

  	<div class="form-group">
    	<label for="name">Product Name</label>
    	<input type="text" class="form-control form-control-sm" name="name" placeholder="Enter product name" value="${requestScope.product.name}" >
  	</div>
  	
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
    		<span class="input-group-text" name="image">Image</span>
  		</div>
  		
  		<div class="custom-file">
    		<input type="file" class="custom-file-input" name="image" aria-describedby="inputGroupFileAddon01">
    		<label class="custom-file-label" for="inputGroupFile01">Choose Product Image</label>
		</div>
	</div>  	
  	
  	<div class="form-group">
 	   <label for="productPrice">Product Price</label>
 	   <input type="text" class="form-control form-control-sm" name="price" placeholder="Enter Product Price" value="${requestScope.product.price }">
  	</div>
  	
  	<div class="form-group">
  		<label for="comment">Product Description</label>
  		<textarea class="form-control form-control-sm" name="description" rows="1" id="comment">${requestScope.product.description}</textarea>
	</div>
  	
	<button type="submit" class="btn btn-primary btn-sm">Update</button>
	</form>

  </div>
</div>
</div>

<div style="padding-left:70px;" >
<button type="button" class="btn btn-secondary" onClick="window.location.href='GetAllProducts'">Back</button>
</div>


</body>
</html>
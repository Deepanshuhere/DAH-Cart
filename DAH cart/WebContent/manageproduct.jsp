<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
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

<div class="container" style="padding-top:100px;">
<div class="card" style="width: 30rem;">
  <div class="card-body">
    <h5 class="display-4 ">Manage Products</h5></br>
	
	<form method="post">
		<p><input type="submit" formaction="add.jsp" style="width:10rem;" value="Add Product" class="btn btn-primary"> &nbsp;To add a new product</p>
		<p><input type="submit" formaction="GetAllProducts" style="width:10rem;" value="Display Product" class="btn btn-primary">&nbsp;&nbsp;To view all the products</p>
	</form>
	
	</div>
	</div>    
</div>

</body>
</html>
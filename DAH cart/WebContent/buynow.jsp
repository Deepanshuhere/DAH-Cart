<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<jsp:include page="header.jsp" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name}</title>

		<!-- BOOTSTRAP -->
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.min.js"></script>  
        <script src="bootstrap/jquery/jquery-3.2.1.min.js"></script>  
        <script src="bootstrap/jquery/popper.min.js"></script>  
        <script src="bootstrap/jquery/bootstrap.min.js"></script>  
        <!-- BOOTSTRAP -->
		
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</head>

<body>

<div class="container" style="padding-top:50px; padding-bottom :40px;" >
<div class="display-3 text-center" style="padding-bottom:30px;">Payment</div>
	<div class="card mx-auto " style="width: 50rem;">
  		<div class="card-body">
<!-- FORM START -->    		
<form action="BuyNow" method="post">
 
 	<div class="form-group">
 		<label for="address"><b>Shipping Address</b></label>
  		<textarea class="form-control" name="address" rows="2" id="comment" placeholder="Enter your address"></textarea>
  	</div>
  	
  	<div class="alert alert-info" role="alert">
		Your Total amount is ${cartAmount }
	</div>
  	
  	<button type="submit" class="btn btn-primary">Pay Now</button>
	  
</form>
<!-- FORM END -->
	
</div>
	</div>
</div>

</body>

</html>

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
<!-- ############################################### -->


<div class="container" style="padding-top:70px; padding-bottom :40px;" >
	<div class="card mx-auto " style="width: 25rem;">
		<div class="card-body">
    	<h5 class="card-title text-center">Update Information</h5>	
  <form action="UpdateCustomer" method="post">
  
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control form-control-sm" name="name" value="${requestScope.customer.name }">
  </div>
   
   <div class="form-group">
    <label for="phone no">Phone No</label>
    <input type="text" class="form-control form-control-sm" name="number" value="${requestScope.customer.phone}" >
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control form-control-sm" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" value="${requestScope.customer.email}"/>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="text" class="form-control form-control-sm" name="password" id="exampleInputPassword1" value="${requestScope.customer.password }">
  </div>
  
  <div class="form-group">
    <label for="answer">Security Answer</label>
    <input type="text" class="form-control form-control-sm" name="answer" value="${requestScope.customer.answer }">
  </div>
  
  <button type="submit" class="btn btn-primary">Update</button>
</form>
    	</div>
	</div>
</div>

</body>
</html>
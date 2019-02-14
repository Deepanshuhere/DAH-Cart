<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>

<!-- BOOTSTRAP -->
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.min.js"></script>  
        <script src="bootstrap/jquery/jquery-3.2.1.min.js"></script>  
        <script src="bootstrap/jquery/popper.min.js"></script>  
        <script src="bootstrap/jquery/bootstrap.min.js"></script>  
<!-- BOOSTRAP -->        


</head>
<body>

<div class="container" style="padding-top:70px; padding-bottom :40px;" >
	<div class="card mx-auto " style="width: 25rem;">
		<div class="card-body">
    	<h5 class="card-title text-center">Sign Up</h5>	
  <form action="Signup" method="post">
  
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control form-control-sm" name="name"  placeholder="Enter your name">
  </div>
  
<div class="form-group">

<label for="gender">Gender</label>
 <div class="form-check form-check-inline">
  <label class="form-check-label">
	    <input type="radio" class="form-check-input" name="gender" value="Men" >Men
	  </label>
	</div>

	<div class="form-check form-check-inline">
	  <label class="form-check-label">
	    <input type="radio" class="form-check-input" name="gender" value="Women" >Women
	  </label>
	</div>
</div>
   
   <div class="form-group">
    <label for="name">Phone No</label>
    <input type="text" class="form-control form-control-sm" name="number"  placeholder="Enter your number">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control form-control-sm" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
    <small class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control form-control-sm" name="password" id="exampleInputPassword1" placeholder="Password">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
    		<br>
    		<p>Already have an account? <a href="login.jsp" class="card-link">Login</a> </p>
  		</div>
	</div>
</div>

<%@ include file="footer.jsp" %>
<%@ include file="contact.jsp" %>
</body>
</html>
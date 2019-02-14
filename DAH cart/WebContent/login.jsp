<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

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
    
<div class="container" style="padding-top:100px; padding-bottom :40px;" >
	<div class="card mx-auto " style="width: 25rem;">
  		<div class="card-body">
  			<h5 class="card-title text-center">LOGIN</h5>
    		

<!-- FORM START ${pageContext.request.contextPath}/ -->
  <form action="Login" method="post">
 
  <div class="form-group">
    <label for="exampleInputEmail1">Email address or Number</label>
    <input type="text" class="form-control" name="id" id="exampleInputEmail1" placeholder="Enter email or number">
    <small id="emailHelp" class="form-text text-muted">We'll never share your details with anyone else.</small>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
  </div>
  
  <button type="submit" class="btn btn-primary">Login</button>
</form>
<!-- FORM END -->

   </br> 		
    		<p>Don't have an account? <a href="signup.jsp" class="card-link"> Create a new account</a></p>
  		</div>
	</div>
</div>

<%@ include file="footer.jsp" %>
<%@ include file="contact.jsp" %>

</body>
</html>
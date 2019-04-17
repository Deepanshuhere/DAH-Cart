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

<div style="padding-top:110px; padding-bottom:20px;">
<div class="card mx-auto" style="width:25rem;">
	  <div class="card-body">
    	<h5 class="card-title text-center">Recover Account</h5>
		
		<form action="ForgotPassword" >
		<div class="form-group">
			<input type="text" class="form-control" name="email" placeholder="Enter your email address">
		</div>
				
		  		<div class="form-group">
   					<input type="text" class="form-control" name="answer" placeholder="Enter your nick name">
			      <small id="emailHelp" class="form-text text-muted">Please enter the same name you entered during signup</small>
  				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	 </div>
	</div>
</div>

<%@ include file="footer.jsp" %>
<%@ include file="contact.jsp" %>


</body>
</html>
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

<div style="padding-top:110px; padding-bottom:20px;">
<div class="card mx-auto" style="width:25rem;">
	  <div class="card-body">
    	<h5 class="card-title text-center">Update Password</h5>
		
		<form action="UpdatePassword">
			
		<div class="form-group">
			<label for="name">Enter your new password</label>
   			<input type="text" class="form-control" name="password" placeholder="Enter the password" required>
   			<input type="hidden" name="email" value="${requestScope.email }">
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		</form>	
	 </div>
	</div>
</div>

<body>
<%@ include file="footer.jsp" %>
<%@ include file="contact.jsp" %>


</body>
</html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>

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

<div class="container" style="padding-top:50px;">
<div class="display-3 text-center" style="padding-bottom:30px;">Customer List</div>
<table class="table table-hover table-sm table-striped table-bordered" >
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Gender</th>
      <th scope="col">Phone</th>
      <th scope="col">Email</th>
    </tr>
  </thead>
  
 <tbody>  
  	<c:forEach items="${customers}" var="customer">
  		<tr>
  			<td>${customer.name}</td>
  			<td>${customer.gender}</td>
  			<td>${customer.phone}</td>
  			<td>${customer.email}</td>
  		</tr>
  	</c:forEach>
 </tbody>

</table>
</div>

<div style="padding-left:70px; padding-top:50px;" >
<button type="button" class="btn  btn-secondary" onClick="window.location.href='admin.jsp'">Back</button>
</div>

</body>
</html>
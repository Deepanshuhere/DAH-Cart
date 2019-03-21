<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<jsp:include page="header.jsp" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clothing</title>
		
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

 <div id="menclothing" class="container" style = "padding-top: 100px;">
          <div class="row">
            			
            <c:forEach items="${products}" var="product">
       		<div class="col-2">
        	<div class="card" >
        	<div>
        	<input type="hidden" name="request_coming" value="index">
       						<a onClick="window.location.href='GetProduct?id=${product.id}'">
        					<img class="card-img-top" src="images/product image/${product.id}.jpg" alt="Card image cap" width="600px" height="150px">
							</a>
			</div>				
							<tr>		
								<div class="card-body">
					       			<h5 class="card-title small">${product.name}</h5>
                    				<p class="font-weight-normal">${product.price}
                    				<a href="CartProducts?productId=${product.id}" class="btn btn-sm btn-primary">Add <img src="images/other/cart.png" width="25" height="25" ></a></p>
                    			</div>
           				   </tr>
           </div>
           </div>
           </c:forEach>
           
      
          </div>
  </div>



</body>
</html>
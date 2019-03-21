<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<jsp:include page="header.jsp" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DAH_CART</title>
		
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

<!-- carousel -->
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel"style="padding-top:45px;" >
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner height:400px">
          <div class="carousel-item active">
              <!-- Use 'www.pixabay.com to download images -->
              <!-- Resize the image to 1920x655 resolution by visiting http://www.simpleimageresizer.com -->
            <img class="d-block w-100" src="images/carousel/a1.jpg" alt="First slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="images/carousel/a.jpg" alt="Second slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="images/carousel/b.jpg" alt="Third slide"> 
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
           <span class="sr-only">Next</span>
        </a>
        </div>
<!-- carousel -->


        <!--################################################################# MEN CLOTHING ########################################################-->
        <div id="menclothing" class="container-fluid" style = "padding-top: 20px;">
          <h1 class="display-4"  style="padding-bottom: 5px;" >Our top selling Men Clothing</h1>
          <div class="row">
            			
            <c:forEach begin="0" end="4" items="${Men}" var="product">
       		<div class="col-2">
        	<div class="card" >
        	<div>
        					<a onClick="window.location.href='GetProduct?id=${product.id}'">
        					<img class="card-img-top" src="images/product image/${product.id}.jpg" alt="Card image cap" width="600px" height="250px">
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
           
           <div style="padding-top:150px;">
           
           <% session.setAttribute("requestFrom","index.jsp"); %>
           
		   <button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='GetProducts?categoryName=Men'" style="height:50px;">All Men Clothing</button>
           </div>
          </div>
        </div>
	  <!-- ############################################################## MEN CLOTHING ##########################################################-->
      
      
      
      <!--################################################################# WOMEN CLOTHING ########################################################-->
        
      <div id="womenclothing" class="container-fluid" style = "padding-top: 20px;">
          <h1 class="display-4"  style="padding-bottom: 5px;" >Women Clothing</h1>
          <div class="row">
            			
            <c:forEach begin="0" end="4" items="${Women}" var="product">
       		<div class="col-2">
        	<div class="card" >
        	<div>
        	<input type="hidden" name="request_coming" value="index">
       						<a onClick="window.location.href='GetProduct?id=${product.id}'">
        					<img class="card-img-top" src="images/product image/${product.id}.jpg" alt="Card image cap" width="600px" height="250px">
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
           
           <div style="padding-top:150px;">
           <button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='GetProducts?categoryName=Women'" style="height:50px;">All Women Clothing</button>
           </div>
          </div>
        </div>
     <!--################################################################# WOMEN CLOTHING ########################################################-->
         
        <!-- ABOUT US-->
              <div id="about_us" class="jumbotron jumbotron-fluid" style="height:18rem;">
                    <div class="container">
                      <h1 class="display-4">About us</h1>
                      <p class="lead">DAH-CART India empowers small and medium-sized businesses to reach millions of customers with a number of 
                            programmes that help boost their revenue, reach and productivity. By telling stories from a wide range of perspectives, 
                            we tell the larger story of who DAH-CART is and how DAH-CART's core business practices contribute to a better India. </p>
                    </div>
              </div>
		<!-- ABOUT US-->
        


<%@ include file="footer.jsp" %>
<%@ include file="contact.jsp" %>

</body>
</html>
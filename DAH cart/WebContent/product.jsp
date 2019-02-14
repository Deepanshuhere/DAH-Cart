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

<div class="container">
<div class="row">

<div class="col">
<img class="card-img-top" src="images/product image/${product.id}.jpg" style="padding-top:100px;" height="550px" width="200px" alt="Card image cap">
</div>

<div class="col" style="padding-top:100px">
<div class="card" style="height:450px">

<div class="card-header" style="height:80px">
<p class="card-title h1 ">${product.name}</p><br>
</div>

<div class="card-body">
<p class="h4">Price - Rs.${product.price }</p>
<p class="h4">Description</p>
<p class="card-text">${product.description}</p>

<p class="h4">Quantity</p>
<div style="width:70px;">
<select class="form-control" id="quantity" name="quantity" >
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select>
</div>

<div style="padding-top:100px">
<button type="button" class="btn btn-primary" onClick="window.location.href='Cart?productId=${product.id}'">Add to cart<img src="images/other/cart.png" width="25" height="25" ></button>
<button type="button" class="btn btn-primary" onClick="window.location.href=''">Buy Now</button>
</div>
</div>
</div>
</div>
</div>
</div>

<div style="padding-left:70px; padding-top:50px;" >
<button type="button" class="btn  btn-secondary" onClick="window.location.href='index.jsp'">Back</button>
</div>
s

</body>
</html>
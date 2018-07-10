<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<title>Add new product</title>
</head>
<body>

	<div class="container">
						
		<h1 class="display-4">Add a New Product</h1>
		<form action="add" method="post">
	
			<div class="form-group">	
			
				<label for="productName">Product Name</label> 			
				<input type="text" class="form-control" name="productName" placeholder="Enter product name" />
						 
			</div>
			
			<div class="form-group">	
			
				<label for="productPrice">Product Price</label> 			
				<input type="text" class="form-control" name="productPrice" placeholder="Enter product price (ex. 29.99)" />
						 
			</div>
	
			<button type="submit" class="btn btn-primary">Submit</button> <br /><br />
			
			<% if (request.getAttribute("status") != null) { %>
			<p class="lead"><%= request.getAttribute("status") %></p>
			
			<a href="manage" class="btn btn-primary">View All Products</a>
			<br />
			<% } %>
			
		</form>
	
	</div>
</body>
</html>
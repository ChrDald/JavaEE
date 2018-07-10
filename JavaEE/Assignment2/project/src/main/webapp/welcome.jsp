<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Product Details</title>
</head>
<body>

	<div class="container">
	
		<%@ page import="java.util.ArrayList" %>
		<%@ page import="model.product" %>
		
		
		<!--  admin section -->
		<% if (request.getAttribute("userRole").equals("admin")) { %>
			
			<h1 class="display-4">Logged in as admin</h1>
			<form action="manage">
				<button type="submit" class="btn btn-info">Manage Products</button>
			</form>
			
			<!--  if manage products is clicked -->
			<% if (request.getAttribute("products") != null) { 
		
			ArrayList<product> list = (ArrayList<product>) request.getAttribute("products");
			
			%>
			<table class="table">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Price</th>
			</tr>
			<% for (product p : list) { 
				int id = p.getId();
				String name = p.getProductName();
				String price = String.valueOf(p.getProductPrice());
			%>
				
				<!--  this is extremely confusing -->
				
				
				<tr>
					<td><%= id %></td>
					<td><%= name %></td>
					<td><%= price %></td>
					<td><a href="deleteProduct?id=<%=id %>">Delete</a>	
				</tr>
				
	
			<% } %>
				
			
			</table>
			
			<% if (request.getAttribute("status") != null) { %>
				<p class="lead"><%= request.getAttribute("status") %></p>
			<% } %>
			
			<a href="add" class="btn btn-primary">Add Product</a>
			<% } %>
			
		<% }
				
		else if (request.getAttribute("userRole").equals("user")) { %>
		
		<!--  user section -->
		
			<h1 class="display-4">Logged in as user</h1>
			<form action="manage">
			
				<button type="submit" class="btn btn-info">View Products</button>
			</form>
			
			<!--  if manage products is clicked -->
			<% if (request.getAttribute("products") != null) { 
		
			ArrayList<product> list = (ArrayList<product>) request.getAttribute("products");
			
			%>
			<table class="table">
			<tr>
				<th>Product Name</th>
				<th>Product Price</th>
			</tr>
			<% for (product p : list) { 
				int id = p.getId();
				String name = p.getProductName();
				String price = String.valueOf(p.getProductPrice());
			%>
				
				<!--  this is extremely confusing -->
				
				
				<tr>
					<td><%= name %></td>
					<td><%= price %></td>
				</tr>
					
			<% } %>
				
			</table>
		<% } 
			} 
			
		else { %>
		
		<h3>Redirect to login?</h3>
		
		<% } %>
	</div>
		
</body>
</html>
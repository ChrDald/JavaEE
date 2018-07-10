<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Calculator</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>


</head>

<body>

	
	<div class="container">
	
		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
		</ul>
	
	<% if (request.getAttribute("error") != null) { %>
		<%= request.getAttribute("error") %>
		
		<% } %>
		
		<form action="Calculate" method="get" >
			
			<h2>Select the Operation</h2>
	
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<button class="btn btn-outline-secondary" type="button" id="add">+</button>
					<button class="btn btn-outline-secondary" type="button" id="sub">-</button>
					<button class="btn btn-outline-secondary" type="button" id="mul">*</button>
					<button class="btn btn-outline-secondary" type="button" id="div">/</button>
				</div>
			</div>
			
			<div class="form-group mt-4">
				<label for="first">First Number</label> 
				<input type="text" class="form-control" name="first" placeholder="Enter the first number"> 
			</div>
			
			<div class="form-group">
				<label for="second">Second Number</label> 
				<input type="text" class="form-control" name="second" placeholder="Enter the second number"> 
			</div>
	
			<% if (request.getAttribute("result") != null) { %>
				
				<%
					String result = request.getAttribute("result").toString();
				%>
				
				<div class="form-group">
					<label for="result">Result</label> 
					<input type="text" class="form-control" value="<%= result %>"> 
				</div>
	
			<% } %>
				<button type="submit" class="btn btn-info">Calculate</button>
				
				<input type="hidden" name="operation" id="operation"/>
			</form>
	</div>
	
		
	<script>
	$( document ).ready(function() {
	    $("#add").click(function() {
	    	$("#operation").val("add");
	    });
	    $("#sub").click(function() {
	    	$("#operation").val("sub");
	    });
	    $("#mul").click(function() {
	    	$("#operation").val("mul");
	    });
	    $("#div").click(function() {
	    	$("#operation").val("div");
	    });
	});
	
	</script>
</body>
</html>
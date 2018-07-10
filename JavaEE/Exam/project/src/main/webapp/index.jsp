<html>

<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<div class="container w-50">

	<h1 class="mt-5">Login Page</h1>

	<% if (request.getAttribute("result") != null) { %>
		<p class="text-success">
		<%= request.getAttribute("result") %>
		</p>
		<% } %>
		
	<% if (request.getAttribute("error") != null) { %>
		<p class="text-danger">
		<%= request.getAttribute("error") %>
		</p>
		<% } %>
		<form action="Login" method="post">
		
			<div class="form-group">
				<label for="username">Username</label> 
				<input type="text" class="form-control" name="username" placeholder="Enter username"> 
			</div>
			
			<div class="form-group">
				<label for="password">Password</label> 
				<input type="text" class="form-control" name="password" placeholder="Enter password"> 
			</div>
	
			<button type="submit" class="btn btn-primary">Sign in</button>
			
			<a href="register.jsp" class="btn btn-primary">Register</a>
		</form>
</div>

</body>
</html>

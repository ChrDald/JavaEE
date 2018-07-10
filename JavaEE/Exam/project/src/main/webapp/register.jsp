<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>


<title>Register</title>
</head>

<body>

	<div class="container">
	<h1>Register as a new user</h1>

		<form action="Register" method="post">

			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" name="email" placeholder="Enter username">
			</div>

			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" name="username" placeholder="Enter username">
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="text"
					class="form-control" name="password" placeholder="Enter password">
			</div>

			<div class="form-group">
				<label for="firstName">First Name</label> <input type="text"
					class="form-control" name="firstName" placeholder="Enter password">
			</div>

			<div class="form-group">
				<label for="lastName">Last Name</label> <input type="text"
					class="form-control" name="lastName" placeholder="Enter password">
			</div>

			<button type="submit" class="btn btn-primary">Register</button>

		</form>
	</div>
	



</body>
</html>
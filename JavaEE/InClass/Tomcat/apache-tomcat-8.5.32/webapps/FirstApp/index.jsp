<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

	<h1>Input Checker</h1>
	

	<form action="Check" method="post">
		
		<label for="username">Username: </label>
		<input type="text" name="username" />
		
		<label for="password">Password: </label>	
		<input type="password" name="password" />
		
		<label for="username">Repeat Username: </label>
		<input type="text" name="usernameCheck" />
		
		<label for="password">Repeat Password: </label>	
		<input type="password" name="passwordCheck" />
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>
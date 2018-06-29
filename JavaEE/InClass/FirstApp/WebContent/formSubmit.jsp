<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

	<% 
	String username = request.getParameter("username"); 
	String password = request.getParameter("password");
	String passwordCheck = request.getParameter("passwordCheck");
			
	if (!password.equals(passwordCheck)) { %>
		<h3>Passwords do Not Match</h3>	
	<%
	} 
	else {
		%><h3>Password Match</h3>
	<%
	} 
	%>
	
	
</body>
</html>
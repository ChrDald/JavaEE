<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% if (request.getAttribute("result").equals("ok")) {%>
		<h1>Registered Successfully</h1>
	<%} else { %>
		<h1>Register Failed</h1> 
		<% } %>
</body>
</html>
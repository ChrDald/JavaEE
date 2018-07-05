<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>

<% if (request.getAttribute("result") != null) {
	
	if (request.getAttribute("result").equals("success")) {
%>
	<h3>Logged in</h3> <% }

else { %>
	<h3>Invalid Log in</h3>
<% } }
%>
	
<h2>Hello World!</h2>

<h3>Login</h3>

<form action="login" method="POST">
	
	<label for="name">Name</label>
	<input type="text" name="name"/>
	
	<label for="password">Password</label>
	<input type="password" name="password"/>
	
	<button type="submit">Submit</button>
</form>

<jsp:include page="header.jsp"></jsp:include>

<a href="displayStudent">Click Me</a>


</body>

</html>

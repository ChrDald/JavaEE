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
	
	<%@ page import = "java.util.Date" %> <!--  imports -->
	<% out.println("test"); %>			<!--  // for java code, if, loops, etc. -->
	<%! int global = 50; %>				<!--  // to declare GLOBAL variables -->
	<%= global %>						<!-- // To display variables, output, not 100% sure -->
	<!--  Basically, calls the toString() method of the expression that is being evaluated. -->
	
	<form action="formSubmit.jsp" method="post">
		
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
	
	<h2>GET action for student</h2>
	<form action="viewStudent" method="GET">
		
		<label for="studentName">Username: </label>
		<input type="text" name="studentName" />
		
		<label for="studentId">studentId: </label>	
		<input type="text" name="studentId" />
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>
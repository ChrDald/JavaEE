<html>
<body>

<%@page import="java.util.ArrayList" %>

<h2>Hello World!</h2>

<form action="main">

<select name="studentId">
	<option>Select a student Id</option>
	
	<% if (request.getAttribute("listId") != null) { 
	
		ArrayList<Integer> list = (ArrayList<Integer>) request.getAttribute("listId");
		
		for (int id : list) {
			
			%> <option value="<%=id %>"><%= id %></option>
		<% }
	}
	%>
	
</select>

	<button type="submit">Get Student</button>
	
</form>

<% if (request.getAttribute("student") != null) { %>

	<h1>Student Info</h1>
	<%= request.getAttribute("student")  %>
	
<% } %>

<% if (request.getAttribute("result") != null) { %>

	<h1>Student Added Successfully</h1>
	
<% } %>

<form action="main" method="post">

	<h3>Add a new Student</h3>
	
	<label for="name">Name</label>
	<input type="text" name="name"/> <br />
	
	<label for="pass">Pass</label>
	<input type="text" name="pass"/> <br />
	
	<button type="submit">Add new student</button>
</form>


</body>
</html>

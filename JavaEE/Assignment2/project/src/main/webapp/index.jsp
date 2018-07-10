<html>

<body>

<% if (request.getAttribute("error") != null) { %>
	<h3>Invalid Username or Password</h3>
<% }
else { %>	
	
<h1>Welcome</h1>

<p>Please login to access the site contents</p>

<% } %>

<form action="login" method="POST">

	<label for="username">Username</label>
	<input type="text" name="username" id="username "/> 
	
	<br/>

	<label for="password">Password</label>
	<input type="text" name="password" id="password" />
	
	<br />
	
	<button type="submit">Login</button>
</form>


</body>
</html>

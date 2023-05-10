<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Form</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style>
		.alert-danger {
			background-color: #f8d7da;
			color: #721c24;
			padding: 10px;
			margin-bottom: 10px;
			border: 1px solid #f5c6cb;
		}
	</style>
</head>
<body>
	<% if (request.getParameter("error") != null) { %>
    <div class="error-message">Please enter both email and password.</div>
    <% } %>
    <% if (request.getParameter("loginFailed") != null) { %>
    <div class="error-message">Invalid email or password, please try again.</div>
    <% } %>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<h2 class="active"> Sign In </h2>
			<h2 class="inactive underlineHover"><a href="register.jsp">Sign Up</a></h2>

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="images/icon.jpg" id="icon" alt="icon">
			</div>

			<!-- Login Form -->
			<form action="login" method="post">
				<input type="text" id="email" class="fadeIn second" name="email" placeholder="Email">
				<input type="password" id="password" class="fadeIn second" name="password" placeholder="Password">
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form>
		</div>
	</div>
</body>
</html>

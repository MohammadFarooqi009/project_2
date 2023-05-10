<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registration Form</title>
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
	<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
	<%-- check if error message is present and display it --%>
	<% if (errorMessage != null) { %>
		<div class="alert alert-danger"><%= errorMessage %></div>
	<% } %>
	<div class="wrapper fadeInDown">
	  <div id="formContent">
	    <!-- Tabs Titles -->
	    <h2 class="active"> Sign Up </h2>
	    <h2 class="inactive underlineHover"><a href="index.jsp">Sign In</a></h2>

	    <!-- Icon -->
	    <div class="fadeIn first">
	     <img src="images/sign-up.png" id= "icon" alt="icon">

	    </div>

	    <!-- Registration Form -->
	    <form action="register" method="POST">
	      <input type="text" id="email" class="fadeIn second" name="email" placeholder="Email">
	      <input type="password" id="password" class="fadeIn third" name="password" placeholder="Password">
	      <input type="submit" class="fadeIn fourth" value="Sign Up">
	    </form>

	 
	  </div>
	</div>
</body>
</html>


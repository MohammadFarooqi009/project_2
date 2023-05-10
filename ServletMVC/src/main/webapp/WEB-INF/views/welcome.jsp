<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="wrapper">
	  <div id="formContent">
	    <!-- Icon -->
	    <div class="fadeIn first">
	     <img src="images/icon.jpg" id= "icon" alt="icon">
	    </div>

	    <!-- Welcome Message -->
	    <h2 class="fadeIn first"> Welcome, <%= request.getSession().getAttribute("email") %>! </h2>
		
		<!-- Logout Button -->
		<form action="login" method="POST">
			<input type="submit" class="fadeIn fourth" value="Log Out">
		</form>
	  </div>
	</div>
</body>
</html>

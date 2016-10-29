<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="./css/furtive.min.css">
	<link rel="stylesheet" href="./css/main.css">
</head>
<body>
	<section class="container--login p2 txt--center brdr--light-gray">
		<h4>Enter your credentials</h4>
		<form action="Login" method="post" role="form" class="my2">
			<input type="text" name="username" placeholder="Username">
			<input type="password" name="password" placeholder="Password">
			<p><font color="red">${errorMsg}</font></p>
			<input type="submit" value="Login" class="btn--blue">
		</form>
	</section>
	<script src="js/main.js"></script>
</body>
</html>

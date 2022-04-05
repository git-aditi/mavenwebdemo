<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

Welcome to Registration page !!! <a href="index.jsp"> Go back to login !!</a>

<form name="registration" action=register method="post">
	<label for="fname">First name:</label><br>
	<input type="text" id="fname" name="fname"><br>
	
	<label for="lname">Last name:</label><br>
	<input type="text" id="lname" name="lname"><br>
	
	<label for="username">Choose Username:</label><br>
	<input type="text" id="username" name="username"><br>
	
	<label for="password">Choose Password:</label><br>
	<input type="password" id="password" name="password"><br>
	
	<label for="repeatPassword">Repeat your Password:</label><br>
	<input type="password" id="repeatPassword" name="repeatPassword"><br>
	
	<label for="address">Address:</label><br>
	<input type="text" id="address" name="address"><br>
	
	<label for="email">Email:</label><br>
	<input type="email" id="email" name="email"><br><br>
	
	<input type="submit" value="Register me!!" name="Register">

</form>



</body>
</html>
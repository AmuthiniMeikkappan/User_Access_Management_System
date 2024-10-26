<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link href="css/signup.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class="signup-container">
			<h2>Sign Up</h2>
			<form action="signup" method="post">
				<div class="input-area">
					<label for="username">Username</label>
					<input type="text" placeholder="Enter username here" name="username" required>
				</div>
				<div class="input-area">
					<label for="password">Password</label>
					<input type="password" placeholder="Enter password here" name="password" required>
				</div>
				<div class="input-area">
					<input type="hidden" name="role" value="Employee">
				</div>
				<button class="btn" type="submit">Sign Up</button>
			</form>
			<p>Already have account ? <a href="login.jsp">Login here</a>
		</div>
</body>
</html>
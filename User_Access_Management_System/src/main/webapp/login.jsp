<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link href="css/login.css" rel="stylesheet" type="text/css" >
<script>
        function showError(message) {
            alert(message);
        }
    </script>
</head>
<body>
<div class="login-container">
			<h2>Login</h2>
			<form action="login" method="post">
				<div class="input-area">
					<label for="username">Username</label>
					<input type="text" placeholder="Enter username here" name="username" required>
				</div>
				<div class="input-area">
					<label for="password">Password</label>
					<input type="password" placeholder="Enter password here" name="password" required>
				</div>
				<button class="btn" type="submit">Login</button>
			</form>
			<p>Doesn't have account ? <a href="signup.jsp">Signup here</a></p>
		</div>
		<%
        String error = (String) request.getAttribute("errorMessage");
        if (error != null) {
    %>
        <script>
            showError("<%= error %>");
        </script>
    <%
        }
    %>
</body>
</html>
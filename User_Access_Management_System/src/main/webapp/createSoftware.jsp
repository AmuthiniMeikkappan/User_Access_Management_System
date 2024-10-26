<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.accessmanagement.model.Software"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link href="css/createSoftware.css" rel="stylesheet" type="text/css" >
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="software-container">
	<h3>CREATE SOFTWARE</h3>
	<form action="createSoftware" method="post">
		<div class="input-area">
			<label for="software-name">Software Name</label>
			<input type="text" name="software-name">
		</div>
		<div class="input-area">
			<label for="description">Description</label>
			<textarea rows="4" cols="20" name="description"></textarea>
		</div>
		<div class="input-area">
			<label for="access-levels">Access Levels</label>
			<div class="levels">
				<input type="checkbox" name="access-levels" value="Read">
				<label for="access-levels">Read</label>
				<input type="checkbox" name="access-levels" value="Write">
				<label for="access-levels">Write</label>
				<input type="checkbox" name="access-levels" value="Admin">
				<label for="access-levels">Admin</label>
			</div>
		</div>
		<button class="btn">Create</button>
	</form>
	</div>
</body>
</html>
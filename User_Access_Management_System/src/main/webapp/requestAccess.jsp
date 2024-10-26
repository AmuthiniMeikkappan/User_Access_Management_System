<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.accessmanagement.model.Software"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link href="css/requestAccess.css" rel="stylesheet" type="text/css" >
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="request-container">
	<h3>REQUEST APPLICATION</h3>
		<form action="request" method="post">
		   <input type="hidden" value="<%= session.getAttribute("username") %>" name="username">
			<div class="input-area">
				<label for="software-name">Software Name</label>
				<select name="software-name">
					<%
						ArrayList<Software> softwareList = (ArrayList<Software>) session.getAttribute("softwareList");
						if(softwareList != null){
							for(Software software : softwareList){
								%>
								<option value="<%= software.getSoftwareName() %>"><%= software.getSoftwareName() %></option>
							<% }
						}
					%>
				</select>
			</div>
			<div class="input-area">
				<label for="access-type">Access Type</label>
				<select name="access-type">
					<option value="Read">Read</option>
					<option value="Write">Write</option>
					<option value="Admin">Admin</option>
				</select>
			</div>
			<div class="input-area">
				<label>Reason for request</label>
				<textarea rows="3" cols="20" name="reason"></textarea>
			</div>
			<button class="btn">Request</button>
		</form>
	</div>
</body>
</html>
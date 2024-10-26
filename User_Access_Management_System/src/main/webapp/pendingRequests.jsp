<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.accessmanagement.model.Request" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link href="css/pendingRequests.css" rel="stylesheet" type="text/css" >
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="pendingrequest-container">
	<h3>PENDING REQUESTS</h3>
	<table border="1">
		
		<%ArrayList<Request> requestList = (ArrayList<Request>)session.getAttribute("requestList");
		int requestCount=0;
		  if(requestList != null){
			   for(Request requests : requestList){
				  if(requests.getStatus().equals("pending")){
				  	requestCount++;
				  	if(requestCount==1){%>
				  	<tr>
				<th>Employee Name </th>
				<th>Software Name </th>
				<th>Access Type </th>
				<th>Reason for Request </th>
				<th colspan="2">Approval</th>
			</tr>
			<%}%>
				  <tr>
				  	<td><%=requests.getUsername() %></td>
				  	<td><%=requests.getSoftwareName() %></td>
				  	<td><%=requests.getAccessType() %></td>
				  	<td><%=requests.getReason() %></td>
				  	<td><a href="approval?status=approved&&requestId=<%= requests.getRequestId() %>" class="btn">Approve</a></td>
				  	<td><a href="approval?status=rejected&&requestId=<%= requests.getRequestId() %>" class="btn">Reject</a></td>
				  </tr>
				  
			<%  }
			}
		  }
		  if(requestCount==0){%>
			  <p class="no-requests">THERE IS NO REQUEST YET!!</p>
		  <%}
		%>
	</table>
</div>
</body>
</html>
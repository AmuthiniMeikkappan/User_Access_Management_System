package com.accessmanagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accessmanagement.dao.RequestDao;
import com.accessmanagement.daoImpl.RequestDaoImpl;
import com.accessmanagement.model.Request;

@WebServlet("/approval")
public class ApprovalServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		String reqStatus = req.getParameter("status");
		
		RequestDao requestdao = new RequestDaoImpl();
		int status = requestdao.updateStatus(requestId, reqStatus);
		
		ArrayList<Request> requestList = new ArrayList<Request>();
		HttpSession session = req.getSession();
		
		if(status != 0 ) {
			requestList = requestdao.getAllRequestDetails();
			session.setAttribute("requestList", requestList);
			resp.sendRedirect("pendingRequests.jsp");
		}
	}

}

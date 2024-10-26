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
import com.accessmanagement.dao.SoftwareDao;
import com.accessmanagement.dao.UserDao;
import com.accessmanagement.daoImpl.RequestDaoImpl;
import com.accessmanagement.daoImpl.SoftwareDaoImpl;
import com.accessmanagement.daoImpl.UserDaoImpl;
import com.accessmanagement.model.Request;
import com.accessmanagement.model.Software;
import com.accessmanagement.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUser(username);
		
        HttpSession session = req.getSession();
        
		if(user != null) {
			if(password.equals(user.getPassword())) {
				if(user.getRole().equals("Employee")) {
					ArrayList<Software> softwareList = (ArrayList<Software>) session.getAttribute("softwareList");
			        
			        // If not in session, retrieve from database
			        if (softwareList == null) {
			            SoftwareDao softwareDao = new SoftwareDaoImpl();
			            softwareList = softwareDao.getAllSoftware(); 
			            session.setAttribute("softwareList", softwareList);
			        }
					session.setAttribute("username", username);
					resp.sendRedirect("requestAccess.jsp");
				}
				else if(user.getRole().equals("Manager")) {
					ArrayList<Request> requestList = (ArrayList<Request>) session.getAttribute("requestList");
			        
			        // If not in session, retrieve from database
			        if (requestList == null) {
			            RequestDao requestDao = new RequestDaoImpl();
			            requestList = requestDao.getAllRequestDetails(); 
			            System.out.println(requestList);
			            session.setAttribute("requestList", requestList);
			        }
					req.setAttribute("username", username);
					req.getRequestDispatcher("pendingRequests.jsp").forward(req, resp);
				}
				else {
					req.setAttribute("username", username);
					req.getRequestDispatcher("createSoftware.jsp").forward(req, resp);
				}
			}
			else {
				req.setAttribute("errorMessage", "Enter the correct email/password");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}
		else {
			req.setAttribute("errorMessage", "You haven't registered yet");
			req.getRequestDispatcher("signup.jsp").forward(req, resp);
		}
	}
}

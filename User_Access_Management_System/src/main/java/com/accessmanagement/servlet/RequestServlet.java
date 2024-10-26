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

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String softwarename = req.getParameter("software-name");
		String accessType = req.getParameter("access-type");
		String reason = req.getParameter("reason");
		
		UserDao userdao = new UserDaoImpl();
		User user = userdao.getUser(username);
		int userId = user.getUserId();
		
		SoftwareDao softwaredao = new SoftwareDaoImpl();
		Software software = softwaredao.getSoftware(softwarename);
		int softwareId = software.getSoftwareId(); 
		
		Request request = new Request(softwarename,accessType,reason);
		RequestDao requestdao = new RequestDaoImpl();
		int status = requestdao.addRequest(request, userId, softwareId);
		 HttpSession session = req.getSession();
		
		if(status != 0) {
			session.setAttribute("username", username);
			session.setAttribute("request", request);
			resp.sendRedirect("requestAccess.jsp");
		}
	}

}

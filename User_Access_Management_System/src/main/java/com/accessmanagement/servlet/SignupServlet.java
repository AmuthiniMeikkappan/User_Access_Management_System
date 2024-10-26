package com.accessmanagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accessmanagement.dao.UserDao;
import com.accessmanagement.daoImpl.UserDaoImpl;
import com.accessmanagement.model.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		User user = new User(username,password,role);
		UserDao userDao = new UserDaoImpl();
		int status = userDao.addUser(user);
		
		if(status != 0 ) {
			resp.sendRedirect("login.jsp");
		}
	}
}

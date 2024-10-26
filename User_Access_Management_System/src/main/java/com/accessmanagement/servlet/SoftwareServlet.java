package com.accessmanagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accessmanagement.dao.SoftwareDao;
import com.accessmanagement.daoImpl.SoftwareDaoImpl;
import com.accessmanagement.model.Software;

@WebServlet("/createSoftware")
public class SoftwareServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String softwareName = req.getParameter("software-name");
		String description = req.getParameter("description");
		String accessLevels = req.getParameter("access-levels");
		
		HttpSession session = req.getSession();
		Software software = new Software(softwareName,description,accessLevels);
		SoftwareDao softwareDao = new SoftwareDaoImpl();
		int status = softwareDao.addSoftware(software);
		if (status != 0) {
            ArrayList<Software> softwareList = (ArrayList<Software>) session.getAttribute("softwareList");
            if (softwareList == null) {
                softwareList = new ArrayList<>();
            }
            softwareList.add(software);
            session.setAttribute("softwareList", softwareList);
            resp.sendRedirect("createSoftware.jsp");
		}
	}

}

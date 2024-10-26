package com.accessmanagement.dao;

import java.util.ArrayList;

import com.accessmanagement.model.Request;

public interface RequestDao {
	
	int addRequest(Request request,int userId,int SoftwareId);
	ArrayList<Request> getAllRequest();
	ArrayList<Request> getAllRequestDetails();
	int updateStatus(int requestId,String status);
}

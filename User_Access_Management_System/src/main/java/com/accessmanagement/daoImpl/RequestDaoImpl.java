package com.accessmanagement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.accessmanagement.connection.DbConnection;
import com.accessmanagement.dao.RequestDao;
import com.accessmanagement.model.Request;
import com.mysql.cj.protocol.x.ResultMessageListener;

public class RequestDaoImpl implements RequestDao {
	
	private final static String ADD_REQUEST = "insert into `requests`(`user_id`,`software_id`,`access_type`,`reason`,`status`) values (?,?,?,?,?)";
	private final static String GET_ALL_REQUEST = "select * from `requests`";
	private final static String GET_ALL_REQUEST_DETAILS = "SELECT r.id, r.user_id, u.username, r.software_id, s.name AS software_name, r.access_type, r.reason, r.status FROM requests r JOIN users u ON r.user_id = u.id JOIN software s ON r.software_id = s.id";
	private final static String UPDATE_STATUS = "update requests SET status = ? where id = ?";
	
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	int status;
	ResultSet result;
	ArrayList<Request> requestList = new ArrayList<Request>();
	
	public RequestDaoImpl() {
		try {
			con = DbConnection.myConnect();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Override
	public int addRequest(Request request,int userId,int softwareId) {
		try {
			pstmt = con.prepareStatement(ADD_REQUEST);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, softwareId);
			pstmt.setString(3, request.getAccessType());
			pstmt.setString(4, request.getReason());
			pstmt.setString(5,"pending");
			
			status = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public ArrayList<Request> getAllRequest() {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(GET_ALL_REQUEST);
			requestList = extractResultSet(result);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requestList;
	}
	
	@Override
	public ArrayList<Request> getAllRequestDetails() {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(GET_ALL_REQUEST_DETAILS);
			requestList = extractDetails(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requestList;
		
	}
	
	public ArrayList<Request> extractResultSet(ResultSet res){
		try {
			while(res.next()) {
				requestList.add(new Request(
						res.getInt("user_id"),
						res.getInt("software_id"),
						res.getString("access_type"),
						res.getString("reason"),
						res.getString("status")
						));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requestList;
	}
	
	public ArrayList<Request> extractDetails(ResultSet res){
		try {
			while(res.next()) {
				requestList.add(new Request(
						res.getInt("id"),
						res.getInt("user_id"),
						res.getString("username"),
						res.getInt("software_id"),
						res.getString("software_name"),
						res.getString("access_type"),
						res.getString("reason"),
						res.getString("status")
						));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requestList;
	}


	@Override
	public int updateStatus(int requestId,String reqStatus) {
		try {
			pstmt = con.prepareStatement(UPDATE_STATUS);
			pstmt.setString(1, reqStatus);
			pstmt.setInt(2, requestId);
			status = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

}

package com.accessmanagement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.accessmanagement.connection.DbConnection;
import com.accessmanagement.dao.SoftwareDao;
import com.accessmanagement.model.Software;

public class SoftwareDaoImpl implements SoftwareDao {
	
	private final static String ADD_SOFTWARE = "insert into `software`(`name`,`description`,`access_levels`) values (?,?,?)";
	private final static String GET_SOFTWARE = "select *  from `software` where `name`=?";
	private final static String GET_ALL_SOFTWARE = "select *  from `software`";
	
	private Connection con;
	private int status;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet result;
	ArrayList<Software> softwareList = new ArrayList<Software>();
	Software software;
	
	public SoftwareDaoImpl() {
		try {
			con = DbConnection.myConnect();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int addSoftware(Software software) {
		try {
			pstmt = con.prepareStatement(ADD_SOFTWARE);
			
			pstmt.setString(1, software.getSoftwareName());
			pstmt.setString(2, software.getDescription());
			pstmt.setString(3, software.getAccessLevels());
			
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Software getSoftware(String softwareName) {
		try {
			pstmt = con.prepareStatement(GET_SOFTWARE);
			pstmt.setString(1, softwareName);
			
			result = pstmt.executeQuery();
			extractResultSet(result);
			
			if(!softwareList.isEmpty()) {
				software = softwareList.get(0);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return software;
	}
	
	ArrayList<Software> extractResultSet(ResultSet res) {
		try {
			while(res.next()) {
				softwareList.add(new Software(
						res.getInt("id"),
						res.getString("name"),
						res.getString("description"),
						res.getString("access_levels")
						));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return softwareList;
	}

	@Override
	public ArrayList<Software> getAllSoftware() {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(GET_ALL_SOFTWARE);
			softwareList = extractResultSet(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return softwareList;
	}

}

package com.accessmanagement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.accessmanagement.connection.DbConnection;
import com.accessmanagement.dao.UserDao;
import com.accessmanagement.model.User;

public class UserDaoImpl implements UserDao {
	
	private final static String ADD_USER = "insert into `users`(`username`,`password`,`role`) values (?,?,?)";
	private final static String GET_USER = "select *  from `users` where `username`=?";
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet result;
	ArrayList<User> userList = new ArrayList<User>();
	User user;
	
	public UserDaoImpl() {
		try {
			con = DbConnection.myConnect();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public int addUser(User user) {
		try {
			pstmt = con.prepareStatement(ADD_USER);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRole());
			
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public User getUser(String username) {
		try {
			pstmt = con.prepareStatement(GET_USER);
			pstmt.setString(1, username);
			
			result = pstmt.executeQuery();
			extractResultSet(result);
			
			if(!userList.isEmpty()) {
				user = userList.get(0);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	ArrayList<User> extractResultSet(ResultSet res) {
		try {
			while(res.next()) {
				userList.add(new User(
						res.getInt("id"),
						res.getString("username"),
						res.getString("password"),
						res.getString("role")
						));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}

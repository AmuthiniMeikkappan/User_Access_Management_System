package com.accessmanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;

final public class DbConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/access_management";
	private static String username = "root";
	private static String password = "root123";
	private static Connection con = null;
	public static Connection myConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

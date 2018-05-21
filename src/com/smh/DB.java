package com.smh;


import java.sql.*;
import java.util.*;



public class DB {
	
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static Statement stmt,stmt1,stmt2;
	private static ResultSet rs;
	private boolean flag;
	
	
	static Connection getConnection() {
		Connection con = null;
		try
		{
			 System.out.println("MySQL Connect Example");
			  String url = "jdbc:mysql://localhost:3306/";
			  String dbName = "smarthome";
			  String driver = "com.mysql.jdbc.Driver";
			  String userName = "root";
			  String password = "root";
			  
			  
			  Class.forName(driver).newInstance();
			  con = DriverManager.getConnection(url+dbName,userName,password);
			  System.out.println("Connected to the database");
			  con.setAutoCommit(true);
			  
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return con;
	}

}




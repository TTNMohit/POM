package com.ttn.database;

import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;

public class DatabaseConnect {
	
	//// Code to Check Database Connectivity
	public String checkDatabase()
	{
		String dbUrl = "jdbc:mysql://172.16.3.247:3306/shiksha";
		String username = "shiksha";
		String password = "shiKm7Iv80l";
		String query = "select * from userShortlistedCourses where userid = 5315276 and courseid = 1666 and status = 'live' order by 1 desc";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl,username,password);
			Statement stmt = con.createStatement();	
			ResultSet rs= stmt.executeQuery(query);		
			while (rs.next()){
        		String courseId = rs.getString(4);								        
                String trackingId = rs.getString(10);	
                if(courseId.equals("1666") && trackingId.equals("936"))
                {
                	return "true";
                }
			}	return "false";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}			
	}

}

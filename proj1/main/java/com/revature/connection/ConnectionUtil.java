package com.revature.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil 
{
	
	public static Connection getConnection() 
	{
		
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://(getthisfromAWS)/postgres";
			String username = "****";
			String password = "********";
			
			return DriverManager.getConnection(url, username, password);
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
}

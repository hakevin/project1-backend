package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.EmployeeBean;
import com.revature.connection.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static EmployeeDAOImpl instance;

	public static EmployeeDAOImpl getInstance() 
	{
		if (instance == null) 
		{
			instance = new EmployeeDAOImpl();
		}
		return instance;
	}

	public EmployeeBean login(String username) 
	{
		EmployeeBean employee = null;
		try 
		{
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users WHERE ers_username = ?");
			ps.setString(1, username);
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) 
			{
				employee = new EmployeeBean(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return employee;
	}


	

	
		
	
}
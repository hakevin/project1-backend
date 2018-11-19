package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.EmployeeDAOImpl;
import com.revature.beans.EmployeeBean;

public class ReimbursementService {
	
// NO FUNCTION	
			
	public static String login(HttpServletRequest request, HttpServletResponse response) {
		//JSONObject loginInfo = getJSONObject(request);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username +" " + password);
		
		EmployeeDAOImpl eDao = new EmployeeDAOImpl(); 
		EmployeeBean employee = new EmployeeBean();
		
//		employee = eDao.login(username,password);
//		System.out.println(employee);
//		if (employee == null) {
//			
//			return "/html/index.html";		
//			
//			//return ("Success!");
//			
//		}
		
		if(username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
			if (employee.getRoleId() == 1) {
				request.getSession().setAttribute("Employee", employee);
				return "/html/ers-employee.html";
			}
		
		else if (employee.getRoleId() == 2) {
			request.getSession().setAttribute("Employee", employee);
			return "/html/ers.html";
			
			//return ("Fail");
		}
			
		}
		return null;
	}
	
	/*JSONObject getJSONObject(HttpServletRequest request) {
		StringBuffer jsonBuffer = new StringBuffer();
		jsonBuffer.append("{ ");
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			
			while ((line = reader.readLine()) != null) {
				line = line.replace('=', ':');
				line = line.replace('&', ',');
				jsonBuffer.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonBuffer.append(" }");
		
		return new JSONObject(jsonBuffer.toString());
		
	}*/
	

}

package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.EmployeeBean;
import com.revature.service.EmployeeService;


public class LoginController {
	
	EmployeeService eService = new EmployeeService();
	
	

	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
			 ObjectMapper mapper = new ObjectMapper();
												//reading request of input from login
			 EmployeeBean login = mapper.readValue(request.getReader(), EmployeeBean.class);
			System.out.println("login controller-login");
			EmployeeBean entrance = eService.usernameAndPasswordValidation(login.getUsername(),login.getPassword());
			
			HttpSession session = request.getSession();
					session.setAttribute("User", entrance);
			System.out.println(session.getAttribute("User"));
			mapper.writeValue(response.getWriter(), entrance);
			response.setContentType("application/json");
			response.getWriter().write(mapper.writeValueAsString(entrance));
}
	}

package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.ReimbursementDAOImpl;
import com.revature.beans.ReimbursementBean;
import com.revature.service.EmployeeService;

public class EmployeeController {
	
EmployeeService eService = new EmployeeService();
ReimbursementDAOImpl rDAO = new ReimbursementDAOImpl();
	

	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
			 ObjectMapper mapper = new ObjectMapper();
												//reading request of input from login
			ReimbursementBean submit = mapper.readValue(request.getReader(), ReimbursementBean.class);
			request.getSession().getAttribute("user");
			rDAO.submitReimbursementList(submit);
			mapper.writeValue(response.getWriter(), submit);
			response.setContentType("application/json");
			response.getWriter().write(mapper.writeValueAsString(submit));
}
}
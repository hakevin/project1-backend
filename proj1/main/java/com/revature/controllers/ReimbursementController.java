package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.ReimbursementDAOImpl;
import com.revature.beans.EmployeeBean;
import com.revature.beans.JoinReimbBean;
import com.revature.beans.ReimbursementBean;

public class ReimbursementController {
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 //ObjectMapper mapper = new ObjectMapper();
											//reading request of input from login
		
		 HttpSession session = request.getSession();
		  EmployeeBean emp = (EmployeeBean)request.getSession().getAttribute("User");
		  System.out.println(request.getAttribute("User"));
		  System.out.println(emp);
		 int user = emp.getUserId();
		 
		 ReimbursementDAOImpl rDAO = new ReimbursementDAOImpl();
		 List<JoinReimbBean> reimbursement = rDAO.getReimbursementList(user);
		 System.out.println(reimbursement);
		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(reimbursement));
		
		
}
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		 
		 
		 ReimbursementDAOImpl rDAO = new ReimbursementDAOImpl();
		 List<JoinReimbBean> reimbursement = rDAO.getAllReimbursements();
		 System.out.println(reimbursement);
		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(reimbursement));
		
		
}
}

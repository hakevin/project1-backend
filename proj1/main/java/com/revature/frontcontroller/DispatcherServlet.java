package com.revature.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.Route;


public class DispatcherServlet extends DefaultServlet {
	
	LoginController loginController = new LoginController();
	EmployeeController employeeController = new EmployeeController();
	ManagerController managerController = new ManagerController();
	ReimbursementController reimbursementController = new ReimbursementController();
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Route route = getRoute(request);
		
		switch(route) {
			case REIMBURSEMENT: reimbursementController.get(request, response); break;
			case MANAGER: reimbursementController.getAll(request, response); break;
			case NOT_FOUND:
			default: response.setStatus(404);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Route route = getRoute(request);
		System.out.println("post-method");
		
		switch(route) {
			case LOGIN: loginController.post(request, response); break;
//			case EMPLOYEE: employeeController.post(request, response); break;
//			case MANAGER: managerController.post(request, response); break;
			case REIMBURSEMENT: employeeController.post(request, response); break;
			case NOT_FOUND:
			default: response.setStatus(404);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Route route = getRoute(request);
		System.out.println("put-method");
		
		switch(route) {
			case APPROVE: managerController.approve(request, response); break;
			case DENY: managerController.deny(request, response); break;
//			case MANAGER: managerController.post(request, response); break;
//			case REIMBURSEMENT: reimbursementController.post(request, response); break;
			case NOT_FOUND:
			default: response.setStatus(404);
		}
	}
	
	static Route getRoute(HttpServletRequest request) {
		String suffix = request.getRequestURI().substring("/project1/".length());
		String routeString = suffix.split("/")[0];
		//sString routeString = request.getRequestURI().split("/")[0];
		try {
			return Route.valueOf(routeString.toUpperCase());
		} catch(IllegalArgumentException e) {
			return Route.NOT_FOUND;
		}
	}
	
}

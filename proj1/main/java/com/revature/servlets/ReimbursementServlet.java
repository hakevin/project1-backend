package com.revature.servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.service.ReimbursementService;



public class ReimbursementServlet extends DefaultServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private ReimbursementService reimbursementService = new ReimbursementService();
    /**
     * @see DefaultServlet#DefaultServlet()
     */
    public ReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   /* @Override
    public void init() {
    	System.out.println("Reimbursement Servlet Initializing");
    }
    
    @Override
    public void destroy() {
    	System.out.println("Reimbursement Servlet Shutting Down");
    }*/
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    		System.out.println("MASTER SERVLET DOGET");
//		String jsonStuff = ReimbursementHelper.direction(request, response);
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(Http ServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("MASTER SERVLET DOPOST");
//		
//		String targetURL = ReimbursementHelper.direction(request, response);
//		request.getRequestDispatcher(targetURL).forward(request, response);
//
//		}
//		
//		
//		
//
//	/**
//	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}


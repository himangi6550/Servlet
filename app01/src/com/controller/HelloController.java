package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.Calculator;


public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HelloController() {}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		Integer fno=Integer.parseInt(request.getParameter("x"));
		Integer sno=Integer.parseInt(request.getParameter("y"));
		
		
		Integer sum=Calculator.sum(fno,sno);
		
		HttpSession httpsession=request.getSession();
		httpsession.setAttribute("result",sum);
		
		
//		request.setAttribute("result", sum);
		
//		RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect("Result.jsp");
		}

	

}

package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public S1() {
       }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("i am in servlet 1"+"<br/>");
		
		request.setAttribute("name", "rajiv");
//		request.removeAttribute("name");
//		RequestDispatcher rd=request.getRequestDispatcher("S2");
//		out.flush();
		response.sendRedirect("S2");
//		rd.include(request, response);
		
		out.print("i am back to 1");
		
	}

	
	
}

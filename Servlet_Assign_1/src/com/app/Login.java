package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int i=1;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int counter=Integer.parseInt(this.getServletContext().getInitParameter("counter"));
		
		if(username.equals(this.getInitParameter("username")) && password.equals(this.getInitParameter("password"))) {
				out.println("Logged in Successfully");
		}
		else
		{
			if(i<counter) {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				out.println("Invalid username and password");
				i++;
			}else {
				out.println("Try again later");
			}
		}
	}

}

package com.options;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Redirecting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String option=request.getParameter("option");
		if(option.equals("unknown"))
			response.sendError(404,"Website not accessible");
		else if(option.equals("gmail"))
			response.sendRedirect("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		else if(option.equals("rediff"))
			response.sendRedirect("https://www.rediff.com/");
		else if(option.equals("yahoo"))
			response.sendRedirect("https://in.search.yahoo.com/?fr2=inr");
		else if(option.equals("hotmail"))
			response.sendRedirect("https://outlook.live.com/owa/");
		
		
	}

}

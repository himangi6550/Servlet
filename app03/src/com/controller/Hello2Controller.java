package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	String name=null;
	String age=null;
	String amdinEmailValue=null;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		name=config.getInitParameter("name");
		age=getInitParameter("age");
		amdinEmailValue=this.getInitParameter(amdinEmailValue);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("hello2 to servlet");
		out.print("name:"+ name);
		out.print("age:"+ age);
		
		out.print("amdinEmailValue"+amdinEmailValue);
	}



}

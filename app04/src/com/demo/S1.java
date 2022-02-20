package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   
	public S1() {
		System.out.println("ctr of s1 is called");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init is called...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("hello by S1");
		System.out.println("doGet of s1 is called");
}
}

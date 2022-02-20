package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public S2() {
		System.out.println("ctr of s2 is called");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init of S2 is called...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("hello by S2");
		System.out.println("doGet of s2 is called");
	}

}

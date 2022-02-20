package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class EmpController
 */
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpController() {
        super();
         }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String ename=request.getParameter("ename");
		String city=request.getParameter("city");
		String desi=request.getParameter("desi");
		Double salary=Double.parseDouble(request.getParameter("salary"));
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yms1?useSSL=false","root","root");
			PreparedStatement pstmt=
					connection.prepareStatement("insert into emp(ename, city, desi, salary) values(?,?,?,?)");
			
			pstmt.setString(1, ename);
			pstmt.setString(2, city);
			pstmt.setString(3, desi);
			pstmt.setDouble(4, salary);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		out.print("ename:"+ ename+"<br>");
		out.print("city:"+ city+"<br>");
		out.print("desi:"+ desi+"<br>");
		out.print("salary:"+ salary+"<br>");
		
	}

}

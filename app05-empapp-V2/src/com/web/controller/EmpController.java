package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.persistence.Employee;
import com.model.service.EmployeeService;
import com.model.service.EmployeeServiceImpl;

public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeService employeeService=new EmployeeServiceImpl();
    
//    public EmpController() {
//        super();
//         }
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String ename=request.getParameter("ename");
		String city=request.getParameter("city");
		String desi=request.getParameter("desi");
		Double salary=Double.parseDouble(request.getParameter("salary"));
		
		
		Employee employee=new Employee(ename,city,desi,salary);
//		employeeService.addEmployee(employee);
//		request.setAttribute("employee", employee);
//		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
//		rd.forward(request, response);
		
//		Employee employee=new Employee(ename, city, desi, salary);
		
		Employee savedEmployee= employeeService.addEmployee(employee);
		
		HttpSession httpSession=request.getSession();
		
		httpSession.setAttribute("employee", savedEmployee);
		response.sendRedirect("result.jsp");
//		out.print("ename:"+ ename+"<br>");
//		out.print("city:"+ city+"<br>");
//		out.print("desi:"+ desi+"<br>");
//		out.print("salary:"+ salary+"<br>");
		
	}

}

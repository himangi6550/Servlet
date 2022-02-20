package com.web.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.persistence.Product;
import com.model.service.*;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ProductService productService = new ProductServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name=request.getParameter("name");
		Double price=Double.parseDouble(request.getParameter("price"));
		int qty=Integer.parseInt(request.getParameter("quantity"));
		Date manfDate = Date.valueOf(request.getParameter("manfDate"));
		Date inspectedDate = Date.valueOf(request.getParameter("inspectedDate"));
		
		Product product=new Product(name,price,qty,manfDate,inspectedDate);
		Product savedProduct = productService.addProduct(product);
		
		HttpSession httpSession=request.getSession();
		
		httpSession.setAttribute("product", savedProduct);			
		response.sendRedirect("resultPage.jsp");
	}

}

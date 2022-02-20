<%@page import="com.model.persistence.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee app</title>
</head>
<body>
<%

Employee employee =(Employee)request.getAttribute("employee");
out.print(employee);
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>

<%
Integer result=(Integer)session.getAttribute("result");
out.print(result+"<br>");
out.print("powered by ymsli");
%>
</body>
</html>
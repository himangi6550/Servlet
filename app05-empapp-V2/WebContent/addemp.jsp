<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Employee</title>
<script src="validate.js"></script>
</head>
<body>
<form action="empcontroller" method="post">
    <table>
        <tr>
            <td>Enter name:</td>
            <td><input type="text" name="ename" id="nameId" /></td>
            <td><label id="nameMsg"></label></td>
        </tr>

        <tr>
            <td>Enter city:</td>
            <td><input type="text" name="city" id="cityId" /></td>
            <td><label id="cityMsg"></label></td>
        </tr>


        <tr>
            <td>Enter Design:</td>
            <td><input type="text" name="desi" id="desiId" /></td>
            <td><label id="desiMsg"></label></td>
        </tr>


        <tr>
            <td>Enter salary:</td>
            <td><input type="text" name="salary" id="salaryId" /></td>
            <td><label id="salaryMsg"></label></td>
        </tr>

        <tr>
            <td><input type="submit" onclick="return validate();" /></td>
        </tr>
    </table>


</form>
</body>
</html>
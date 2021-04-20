<%@page import="com.te.springmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String errmsg=(String)request.getAttribute("errmsg"); 
    EmployeeBean bean=(EmployeeBean)request.getAttribute("data");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(errmsg!=null && !errmsg.isEmpty()){ %>
<%=errmsg %>
<%} %>
<fieldset>
<legend>login</legend>
<form action="./emplogin" method="post">
<table>
<tr>
<td>Enter Id</td>
<td>:</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td>Enter Password</td>
<td>:</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="login"></td>
</tr>

</table>


</form>
</fieldset>
</body>
</html>
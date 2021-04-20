<%@page import="com.te.springmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<%
	String msg=(String)request.getAttribute("msg");
	EmployeeBean bean=(EmployeeBean)request.getAttribute("data");
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(msg!=null && !msg.isEmpty()) { %>
<%=msg %>
<%} %>
	<fieldset>

		<legend>Search</legend>
		<form action="./search1" method="get">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="text" name="id"></td>

				</tr>
				<tr>
					<td><input type="submit" value="search"></td>
				</tr>

			</table>

		</form>
	</fieldset>
	<% if(bean!=null){ %>
	<h4>name : <%=bean.getName() %></h4>
	<h4>ID: <%=bean.getBirthdate() %></h4>
	<%} %>
</body>
</html>
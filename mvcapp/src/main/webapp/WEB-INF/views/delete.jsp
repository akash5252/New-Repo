<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
      <%String msg = (String) request.getAttribute("msg"); 
    String errmsg = (String) request.getAttribute("errmsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(msg!=null && !msg.isEmpty()){
	%>
<h2><%=msg %></h2>
<%
} 
%>

<%
if(errmsg!=null && !errmsg.isEmpty()){
	%>
<h2><%=errmsg %></h2>
<%
} 
%>


<fieldset>
<legend>delete</legend>
<form action="./delete" method="get">
		<table>
			<tr>
				<td>Id to Delete</td>
				<td>:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="delete"></td>
			</tr>
		</table>

	</form>
</fieldset>
</body>
</html>
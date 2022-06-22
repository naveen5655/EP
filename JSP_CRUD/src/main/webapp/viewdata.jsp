<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%@ page import="java.util.*" %>
	<%@ page import="com.model.*" %>
	<% @SuppressWarnings("unchecked")  List<Student> L = (List<Student>) request.getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>CGPA</th>
		</tr>
		
		<% for(Student S:L) {%>
			<tr>
				<td> <%=S.getStudentid() %> </td>
				<td> <%=S.getName() %> </td>
				<td> <%=S.getCgpa() %> </td>
			</tr>
		<%}%>
	</table>
</body>
</html>
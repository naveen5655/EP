<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
</head>
<body>
	<h3>Add New Student</h3>
	<form action="AddData" method="get">
		Student ID: <input type="text" name="sid" /> <br/><br/>
		Student Name: <input type="text" name="sname" /> <br/><br/>
		Student CGPA: <input type="text" name="scgpa" /> <br/><br/>
		<input type="submit" value="SAVE" />
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Students</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse,">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<c:forEach var="s" items="${students}">
			<tr>
				<td>${s.getId()}</td>
				<td>${s.getName()}</td>
				<td>${s.getEmail()}</td>
				<td><a href="delete?id=${s.getId()}">Delete</a></td>
				<td><a href="update?id=${s.getId()}">Update</a></td>		
			</tr>
		</c:forEach>	
	</table>
</body>
</html>
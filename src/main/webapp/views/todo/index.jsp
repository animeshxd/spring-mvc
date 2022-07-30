<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo App</title>
</head>
<body>
	<div style="justify-content: space-between; display: flex;">
	<h3>List</h3> <a href="">refresh</a>
	</div>
	<hr style="margin-top: 5px;">
	<ul>
		<c:forEach var="i" items="${data}"> 
			<li><c:out value="${i}"></c:out></li>
		</c:forEach>
	</ul>
	<br>
	<p>Add Items</p>
	<form action="" method="post">
		<input type="text" name="data" autofocus="true">
		<br>
		<button type="submit">add item</button>
	</form>
	
 
	
	
</body>
</html>
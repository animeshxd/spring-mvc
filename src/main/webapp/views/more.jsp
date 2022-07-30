<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	This is ${string}  <br>
	This is ${ _int }  <br>
	This is ${ list }  <br>
	This is ${ datetime } <br>

	<c:forEach var="i" items="${list}">
		<c:out value="${i}"></c:out> <br>
	</c:forEach>
	
</body>
</html>
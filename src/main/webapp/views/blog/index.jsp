<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog Home</title>
<style type="text/css">
	body {
		background-color: cornsilk;
		margin: 0px;

	}
	.nav a {
		text-decoration: none;
		display: inline-block;
		background-color: teal;
		color: white;
		padding: .5em .3em;
	}
	
	.nav {
		padding: .5em;
		background-color: NavajoWhite;
		
	}
	.posts h4 {
		color: maroon;
	}
	
	.posts {
		margin: 12px;
	}
	
	.posts a {
		font-size: 12px;
	}
	
</style>
</head>
<body>
	<div class="nav">
		<a href="">Home</a>
		<a href="create">Create Blog Post</a>
	</div>
	
	<div class="posts">
		<div>
		<c:forEach var="i" items="${blogs}">
			<h4>${i.value.title}</h4>
			<p>${i.value.content}</p>
			<a href="delete?id=${i.key}">delete</a>
			<hr>
		</c:forEach>
		</div>
	</div>
</body>
</html>
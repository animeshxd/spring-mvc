<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${blog.title}</title>
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
	.post h4 {
		color: maroon;
	}
	
	.post {
		margin: 12px;
	}
	
	.post a.custom {
		font-size: 12px;
	}
	
</style>
</head>
<body>
	<div class="nav">
		<a href="./">Home</a>
		<a href="create">Create Blog Post</a>
	</div>
	<div class="post">
		<h4>${blog.title}</h4>
		<p>${blog.content}</p>
		<a class="custom" href="delete?id=${blog.id}">delete</a>
		<hr>
	</div>
</body>
</html>
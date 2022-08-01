<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Blog Post</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
	body {
		background-color: cornsilk;


	}
</style>
</head>


<body>
	<form action="create" method="post">
		<input type="text" name="id" value="${id}" hidden/>
		Title:  <input type="text" name="title" required="required" value="${blog.title}"/><br>
		<p> Content: </p>
		<textarea rows="10" cols="70" style="max-width: 98%;" name="content" required="required">${blog.content}</textarea>
		<br><br>
		<button>Submit Post</button>
	</form>
	
</body>
</html>
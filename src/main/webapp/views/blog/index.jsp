<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
		text-decoration: none;
		color: maroon;
	}
	.posts a.custom {
		font-size: 12px;
	}
	
	.success {
		font-size: 14px;
		padding: 12px;
		background-color: DarkSalmon;
		border: 12px;
	}

	
</style>
</head>
<body>
	<div class="nav">
		<a href="./">Home</a>
		<a href="create">Create Blog Post</a>
	</div>
	
	<div class="posts">
		<c:if test="${success}">
			<div class="success">Successfully deleted post</div>
		</c:if>
		<div>
			<c:forEach var="i" items="${blogs}">
				<c:set var="content" value="${i.content}"></c:set>
				<h4><a href="post?id=${i.id}">${fn:escapeXml(i.title)}</a></h4>
				<p>${fn:escapeXml(fn:substring(content, 0, 200))}</p>
				<span>
					<a class="custom" href="delete?id=${i.id}">delete</a>
					<a class="custom" href="edit?id=${i.id}">edit</a>
				</span>
				<hr>
			</c:forEach>
		</div>
	</div>
</body>
</html>

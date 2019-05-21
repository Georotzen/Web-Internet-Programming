<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey Builder</title>
<style>
	a:visited, a:link, a:hover {
		color: blue;
		text-decoration: none;
	}
</style>
</head>
<body>
<h3>Survey Builder</h3>
<p><a href="CreateSurvey">Create Survey</a></p>
<c:forEach items="${surveys}" var="survey">
<ul>
	<li style="margin-left: 40px;"><a href="ViewSurvey?id=${survey.id}">${survey.name}</a></li>
</ul>
</c:forEach>
</body>
</html>
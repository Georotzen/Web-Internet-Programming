<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${survey.name}</title>
<style>
	a:visited, a:link, a:hover {
		color: blue;
		text-decoration: none;
	}
</style>
</head>
<body>
<h3><a href="SurveyBuilder">Survey Builder</a> > ${survey.name} </h3>

<p><a href="AddQuestion?id=${survey.id}">Add Question</a></p>
<c:forEach items="${questions}" var="question" varStatus="loop">

	<p>${loop.index + 1}) ${question.description}</p>
	<c:forEach items="${question.choices}" var="choice">
		<div><input type="radio" name="${loop.index + 1}" required>${choice}</div>
	</c:forEach>
</c:forEach>
</body>
</html>
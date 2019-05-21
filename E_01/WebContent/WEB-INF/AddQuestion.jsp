<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question for ${survey.name}</title>
<style>
	a:visited, a:link, a:hover {
		color: blue;
		text-decoration: none;
	}
</style>
</head>
<body>
<h3><a href="SurveyBuilder">Survey Builder</a> > 
<a href="ViewSurvey?id=${survey.id}">${survey.name}</a> > Add Question </h3>
<form action="AddQuestion" method="post">
<p>Question: <textarea cols="60" name="question" rows="1" required></textarea></p>
Choices: 
<ol>
	<li style="margin-left: 40px;"><input type="text" name="choice0" required></li>
<c:forEach var="i" begin="1" end="9">
	<li style="margin-left: 40px;"><input type="text" name="choice${i}"></li>
</c:forEach>
</ol>
<input type="hidden" name="questionId" value="${questionId}"/>
<input type="hidden" name="id" value="${survey.id}"/>
<input type="submit" name="add Question" value="Add Question">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Championship</title>
</head>
<body>
<h3>Bracketology</h3>
<c:if test="${matches.size() >= 1}" >
<form action="Championship" method="post">
<c:forEach items="${matches}" var="match" varStatus="loop">
	<p>Match ${loop.index + 1}: 
	<input type="radio" name="match${loop.index + 1}" value="${match.key}" required><label for="team1" >${match.key}</label>
	<input type="radio" name="match${loop.index + 1}" value="${match.value}" required><label for="team1">${match.value}</label></p> 
</c:forEach>
<div><input type="submit" name="next" value="Next"/></div>
</form>
</c:if>
<c:if test="${matches.size() == 0}">
<p>The champion is: ${winner}</p>
<form action="Championship" method="post">
	<div><input type="submit" name="next" value="Start Over"/></div>
</form>
</c:if>
</body>
</html>
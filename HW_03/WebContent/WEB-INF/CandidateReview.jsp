<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate Review</title>
<style>
	table { 
		text-align: left;
		border: 1px solid black;
		border-collapse: collapse;
		margin-left: 10px;
		margin-right: 10px;
	}
	th, td { 
		text-align: left;
		border: 1px solid black;
		border-collapse: collapse;
		padding: 3px 3px 3px 3px;
		spacing: 3px 3px 3px 3px;
	}
	a:visited, a:link, a:hover {
		color: blue;
		text-decoration: none;
	}
</style>
</head>
<body>
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Specialities</th>
		<th>Presentation</th>
		<th>Rating</th>
		<th>Operation</th>
	</tr>
<c:forEach items="${candidates}" var="candidate" >
	<tr>
		<td style="text-align: center;">${candidate.id}</td>
		<td><a href="CandidateFeedback?id=${candidate.id}">${candidate.name}</a></td>
		<td>${candidate.specialities}</td>
		<td>${candidate.presentation}</td>
		<c:if test="${candidate.rating == 0.0}">
			<td>N/A</td>
		</c:if>
		<c:if test="${candidate.rating != 0.0}">
			<td><fmt:formatNumber value="${candidate.rating}" pattern="0.0" /></td>
		</c:if>
		<td style="text-align: center;"><a href="EditCandidate?id=${candidate.id}">Edit</a></td>
	</tr>	
</c:forEach>
</table>
<p style="padding-left: 10px;"><a href="AddCandidate">Add Candidate</a></p>
</body>
</html>
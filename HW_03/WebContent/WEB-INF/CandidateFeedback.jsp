<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${candidate.name}'s Feedback</title>
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
	p {
		padding-left: 10px;
	}
</style>
</head>
<body>
<p><a href="CandidateReview">Back to Candidates</a></p>
<table>
	<tr>
		<th style="text-align: center;">ID</th>
		<th style="text-align: center;">Name</th>
		<th style="text-align: center;">Specialities</th>
		<th style="text-align: center;">Presentation</th>
		<th style="text-align: center;">Rating</th>
	</tr>
	<tr>
		<td style="text-align: center;">${candidate.id}</td>
		<td style="text-align: center;">${candidate.name}</td>
		<td style="text-align: center;">${candidate.specialities}</td>
		<td style="text-align: center;">${candidate.presentation}</td>
		<c:if test="${candidate.rating == 0.0}">
			<td style="text-align: center;">N/A</td>
		</c:if>
		<c:if test="${candidate.rating != 0.0}">
			<td style="text-align: center;"><fmt:formatNumber value="${candidate.rating}" pattern="0.0" /></td>
		</c:if>
</table>
<p>Comments:</p>
<table>
<c:forEach items="${candidate.feedback}" var="feedback">
	<tr>
		<td>Rating: ${feedback.rating}</td>
		<td style="text-align: right;">Posted by ${feedback.name} on ${feedback.date}</td>
	</tr>
	<tr>
		<td colspan="2" rowspan="1">${feedback.comment}</td>
	</tr>
</c:forEach>
</table>
<p>Please give your feedback:</p>
<form action='CandidateFeedback' method='post'>
<table>
	<tr>
		<th style="text-align: center;">Rating</th>
		<td>
			1 <input name="rating" type="radio" value="1"> 
			<input name="rating" type="radio" value="2"> 
			<input name="rating" type="radio" value="3" required checked> 
			<input name="rating" type="radio" value="4"> 
			<input name="rating" type="radio" value="5"> 5
		</td>
	</tr>
	<tr>
		<th style="text-align: center;">Name</th>
		<td><input type="hidden" name="id" value="${candidate.id}"/><input name="name" type="text" size="40" required/></td>
	</tr>
	<tr>
		<th style="text-align: center;">Comments</th>
		<td><textarea cols="20" name="comment" rows="1" required></textarea></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="1"><input type="submit" name="Submit" value="Submit"/></td>
	</tr>
</table>
</form>
</body>
</html>
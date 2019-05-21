<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Candidate</title>
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
		padding: 2px 2px 2px 2px;
		spacing: 2px 2px 2px 2px;
	}
	p {
		color: RED;
		padding-left: 10px;
	}
</style>
</head>
<body>
<c:if test="${is_Admin == false}"> 
<p>You are not allowed to perform this action. <a href="CandidateReview">Go Back to Candidate Review</a></p>
</c:if>
<c:if test="${is_Admin == true}">
<form action="AddCandidate" method="post">
<table>
	<tr>
		<th>Name</th>
		<td><input type="text" name="name" size="60"/></td>
	</tr>
	<tr>
		<th>Specialities</th>
		<td><input type="text" name="specialities" size="60"/></td>
	</tr>
	<tr>
		<th>Presentation</th>
		<td><input type="text" name="presentation" size="60"/></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="1"><input type="submit" name="add" value="Add"/></td>
	</tr>
</table>
</form>
</c:if>
</body>
</html>

		
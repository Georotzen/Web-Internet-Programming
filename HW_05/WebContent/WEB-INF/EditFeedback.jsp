<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Feedback</title>
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
<c:forEach items="${feedbacks}" var="feedback">
<c:if test="${username != feedback.name || username == null}"> 
<p>You are not allowed to perform this action. <a href="CandidateReview">Go Back to Candidate Review</a></p>
</c:if>
<c:if test="${username == feedback.name}">
<form action='EditFeedback' method='post'>
<table>
	<tr>
		<th style="text-align: center;">Rating</th>
		<td>
			<c:if test="${param.rating == 1}" >
				1 <input name="ratingUpdate" type="radio" value="1" checked> 
				<input name="ratingUpdate" type="radio" value="2"> 
				<input name="ratingUpdate" type="radio" value="3" required>
				<input name="ratingUpdate" type="radio" value="4">
				<input name="ratingUpdate" type="radio" value="5"> 5
			</c:if>
			<c:if test="${param.rating == 2}" >
				1 <input name="ratingUpdate" type="radio" value="1"> 
				<input name="ratingUpdate" type="radio" value="2" checked> 
				<input name="ratingUpdate" type="radio" value="3" required>
				<input name="ratingUpdate" type="radio" value="4">
				<input name="ratingUpdate" type="radio" value="5"> 5
			</c:if>
			<c:if test="${param.rating == 3}" >
				1 <input name="ratingUpdate" type="radio" value="1"> 
				<input name="ratingUpdate" type="radio" value="2"> 
				<input name="ratingUpdate" type="radio" value="3" required checked>
				<input name="ratingUpdate" type="radio" value="4">
				<input name="ratingUpdate" type="radio" value="5"> 5
			</c:if>
			<c:if test="${param.rating == 4}" >
				1 <input name="ratingUpdate" type="radio" value="1"> 
				<input name="ratingUpdate" type="radio" value="2"> 
				<input name="ratingUpdate" type="radio" value="3" required>
				<input name="ratingUpdate" type="radio" value="4" checked>
				<input name="ratingUpdate" type="radio" value="5"> 5
			</c:if>
			<c:if test="${param.rating == 5}" >
				1 <input name="ratingUpdate" type="radio" value="1"> 
				<input name="ratingUpdate" type="radio" value="2"> 
				<input name="ratingUpdate" type="radio" value="3" required>
				<input name="ratingUpdate" type="radio" value="4">
				<input name="ratingUpdate" type="radio" value="5" checked> 5
			</c:if>
			
		</td>
	</tr>
	<tr>
		<th style="text-align: center;">Name</th>
		<td>
			<input type="hidden" name="parent_idUpdate" value="${param.parent_id}"/>
			<input type="hidden" name="nameUpdate" value="${feedback.name}" size="40"/>
			${feedback.name}
		</td>
	</tr>
	<tr>
		<th style="text-align: center;">Comments</th>
		<td><textarea cols="60" name="commentUpdate" rows="5" required>${feedback.comment}</textarea></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="1"><input type="submit" value="Submit"/></td>
	</tr>
</table>
</form>
</c:if>
</c:forEach>
</body>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
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
</style>
</head>
<body>
<form action='EditCandidate' method='post'>
<table>
	<tr>
		<th>ID</th>
		<td>${candidate.id}<input type="hidden" name="id" value="${candidate.id}"/></td>
	</tr>
	<tr>
		<th>Name</th>
		<td><input type="text" name="name" size="60" value="${candidate.name}"/></td>
	</tr>
		<tr>
		<th>Specialities</th>
		<td><input type="text" name="specialities" size="60" value="${candidate.specialities}"/></td>
	</tr>
		<tr>
		<th>Presentation</th>
		<td><input type="text" name="presentation" size="60" value="${candidate.presentation}"/></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="1"><input type="submit" value="Save" name="save" /></td>
	</tr>
</table>
</form>
</body>
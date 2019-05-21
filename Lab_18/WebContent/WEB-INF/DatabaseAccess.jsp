<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Access</title>
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
<p style="padding-left: 10px;">[<a href="AddFolder?id=NULL">New Folder</a>]</p>
<table>
<c:if test="${files.size() == 0}">
		<p style="padding-left: 10px;"> This folder is empty! </p>
</c:if>
<c:if test="${files.size() > 0}">
	<c:forEach items="${files}" var="file" >
	<tr>
		<c:if test="${file.is_folder}">
			<td>\<a href="Folder?id=${file.id}">${file.name}</a></td>
		</c:if>
		<c:if test="${!file.is_folder}">
			<td>${file.name}</td>
		</c:if>
		<td><a href="DeleteFolder?id=${file.id}">Delete</a></td>
	</tr>
	</c:forEach>
</c:if>
</table>
</body>
</html>
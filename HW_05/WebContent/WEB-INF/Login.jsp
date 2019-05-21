<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
	table {
		margin: 1em auto;
		padding-top: 50px;
	}
	
	p {
		color: red;
	}
</style>
</head>
<body>
<c:if test="${username != null}">
	 You already logged in / <a href="Logout">Logout?</a>
</c:if>
<c:if test="${username == null}">
<form action="Login" method="post">
<table>
	<tr>
		<td>Username</td>
		<td><input type="text" name="username" required></input></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" required></input></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>
</c:if>
${username}
${password}
${is_Admin}
</body>
</html>
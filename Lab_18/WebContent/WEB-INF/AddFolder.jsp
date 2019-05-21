<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Folder</title>
</head>
<body>
<form action="AddFolder" method="post">
	<p style="padding-left: 10px;">Folder Name  <input type="text" name="name" size="60"/></p>
	<input type="hidden" name="parent_id" value="${param.id}"/>
	<p style="padding-left: 10px;"><input type="submit" name="add" value="AddFolder"/></p>
</form>
</body>
</html>
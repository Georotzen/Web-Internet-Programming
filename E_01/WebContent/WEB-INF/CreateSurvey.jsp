<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Survey</title>
<style>
	a:visited, a:link, a:hover {
		color: blue;
		text-decoration: none;
	}
</style>
</head>
<body>
<h3><a href="SurveyBuilder">Survey Builder</a> > Create Survey</h3>
<form action="CreateSurvey" method="post">
<p>Name of the survey: <input type="text" name="name" size="25"/>
<input type="submit" name="create" value="Create"/></p>
</form>
</body>
</html>
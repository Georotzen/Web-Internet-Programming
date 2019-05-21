<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driving Test</title>
</head>
<body>
<div> ${questions[id].description} </div>
<div> 1. ${questions[id].answerA} </div> 
<div> 2. ${questions[id].answerB} </div> 
<div> 3. ${questions[id].answerC} </div> 
<div>Correct Answer: ${questions[id].correctAnswer} </div> 
<p><a href="DrivingTestBrowser?id=${id + 1}" >Next</a></p>
</body>
</html>
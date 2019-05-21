<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currency Converter</title>
</head>
<body>
<p><fmt:formatNumber value="${amount}" pattern="0.###" /> ${c1} = 
<fmt:formatNumber value="${result}" pattern="0.###" /> ${c2} </p>
<p><a href="CurrencyConverter">Back</a></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses</title>
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
<p style="padding-left: 10px;"><strong>Total: </strong>$<fmt:formatNumber value="${total}" type="currency" currencySymbol=""/></p>

<form action="AddExpense" method="post">
<table>
	<tr>
		<th>Month</th>
		<th>Amount</th>
		<th>Tags</th>
		<th>Operation</th>
	</tr>
<c:forEach items="${expenses}" var="expense">
	<tr>
		<td><a href="FilterByMonth?month=${expense.month}">${expense.month}</a></td>
		<td>$<fmt:formatNumber value="${expense.amount}" type="currency" currencySymbol=""/></td>
		<td>
			<c:forEach items="${expense.tags}" var="tag" varStatus="status">
				<c:if test="${status.last}">
					<a href="FilterByTag?tag=${tag}">${tag}</a>
				</c:if>
				<c:if test="${!status.last}">
					<a href="FilterByTag?tag=${tag}">${tag}</a>,
				</c:if>
			</c:forEach>
		</td>
		<td><a href="DeleteExpense?id=${expense.id}">Delete</a></td>
	</tr>
</c:forEach>
	<tr>
		<td><input type="text" name="month" /></td>
		<td><input type="text" name="amount" /></td>
		<td><input type="text" name="tags" /></td>
		<td><input type="submit" value="Add"/></td>
	</tr>
</table>
</form>
<p><a href="Expenses">Reset Filter</a></p>
</body>
</html>
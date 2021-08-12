<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h2>New Dojo</h2>
	<form:form action="/dojos/new" method="post" modelAttribute="dojo">

		<tr>


			<td><form:label path="name">Name</form:label></td>
			<td><form:errors path="name" /></td>
			<td><form:input path="name" /></td>
		</tr>
		<br>
		<br>

		<input type="submit" value="Create" />

	</form:form>

</body>
</html>
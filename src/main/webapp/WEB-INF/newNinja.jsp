<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
	<h2>New Ninja</h2>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">

			<form:label path="dojo">Dojo :</form:label>
			<form:select path="dojo">
				<c:forEach items="${ dojos }" var="dojo">
					<form:option value="${ dojo.id }">
						<c:out value=" ${ dojo.name }" />
					</form:option>
				</c:forEach>
			</form:select>
	
		<br>
		<br>

		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<td><form:errors path="firstName" /></td>
			<td><form:input path="firstName" /></td>
		</tr>
		<br>
		<br>
		<tr>
			<td><form:label path="lastName">Last Name:</form:label></td>
			<td><form:errors path="lastName" /></td>
			<td><form:input path="lastName" /></td>
		</tr>
		<br>
		<br>
		<tr>
			<td><form:label path="age">Age:</form:label></td>
			<td><form:errors path="age" /></td>
			<td><form:input path="age" /></td>
		</tr>
		<br>
		<br>

		<input type="submit" value="Create" />

	</form:form>

</body>
</html>
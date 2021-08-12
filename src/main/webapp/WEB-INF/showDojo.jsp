<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
</head>
<body>
	<form:form action="/dojos/${id}" modelAttribute="ninjaByDojo">
		<h3>
			<c:out value="${dojo.name}" />
			Location Ninjas!
		</h3>
		 <table>
				<thead>
					<tr>
						<th ><h4>First Name</h4></th>
						<th ><h4>Last Name</h4></th>
						<th ><h4>Age</h4></th>
					</tr>					        		
				</thead>
				<tbody>
					<c:forEach items="${ ninjas }" var="ninja">
						<tr>
							<td><c:out value="${ ninja.firstName }"/></td>
							<td><c:out value="${ ninja.lastName }"/></td>
							<td><c:out value="${ ninja.age }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</form:form>

	<a href="/dojos/new">Add a dojo</a>
	<a href="/ninjas/new">Add a ninja</a>

</body>
</html>
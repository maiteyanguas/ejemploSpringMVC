<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Lista de Personas</title>
</head>
<body>
	<h2>Lista de Personas:</h2>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
		</tr>
		<c:forEach items="${personas}" var="persona">
		<tr>
			<td>${persona.nombre}</td>
			<td>${persona.apellido}</td>
			<td>${persona.edad}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
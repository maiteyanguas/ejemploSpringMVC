<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Persona nueva</title>
</head>
<body>
	<h2>Persona nueva:</h2>
	<form:form method="POST" modelAttribute="persona" action="/ejemplo6/persona/add">
		<table>
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td><form:label path="apellido">Apellido:</form:label></td>
				<td><form:input path="apellido"/></td>
			</tr>
			<tr>
				<td><form:label path="fechaNacimiento">Fecha de Nacimiento (dd/mm/yyyy):</form:label></td>
				<td><form:input path="fechaNacimiento"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
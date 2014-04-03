<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Persona nueva</title>
</head>
<body>
	<h2>Persona nueva:</h2>
	<form:form method="POST" modelAttribute="persona" action="/ejemploSpringMVC/persona/add">
	<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre"/></td>
				<td><form:errors path="nombre" cssClass="error" /></td>				
			</tr>
			<tr>
				<td><form:label path="apellido">Apellido:</form:label></td>
				<td><form:input path="apellido"/></td>
				<td><form:errors path="apellido" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="edad">Edad:</form:label></td>
				<td><form:input path="edad"/></td>
				<td><form:errors path="edad" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
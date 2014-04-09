<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Editar Persona</title>
</head>
<body>
	<h2>Editar Persona</h2>
	<form:form method="POST" modelAttribute="persona" action="/ejemploSpringMVC/persona/update">
	<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<form:hidden path="id"/>
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
				<td><form:label path="fechaNacimiento">Fecha de Nacimiento (dd/mm/yyyy):</form:label></td>
				<td><form:input path="fechaNacimiento"/></td>
				<td><form:errors path="fechaNacimiento" cssClass="error" /></td>
			</tr>
			<c:forEach var="direccion" items="${persona.direcciones}" varStatus="status">
				<tr>
					<td>Direccion ${status.index+1} </td>
					<td colspan="2">${direccion.direccionSimple}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Enviar"/> <a href="/ejemploSpringMVC/persona/list">Cancelar</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
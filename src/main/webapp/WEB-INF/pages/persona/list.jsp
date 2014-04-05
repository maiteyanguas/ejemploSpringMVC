<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<title><spring:message code="persona.lista" text="Lista de Personas"/></title>
</head>
<body>
	<div class="idioma">Idioma : <a href="?language=es">Español</a>|<a href="?language=eu_ES">Euskara</a></div>
	<h2><spring:message code="persona.lista" text="Lista de Personas"/></h2>
	<table>
		<tr>
			<th><spring:message code="datos.persona.nombre" text="Nombre"/></th>
			<th><spring:message code="datos.persona.apellido" text="Apellido"/></th>
			<th><spring:message code="datos.persona.edad" text="Edad"/></th>
		</tr>
		<c:forEach items="${personas}" var="persona">
		<tr>
			<td>${persona.nombre}</td>
			<td>${persona.apellido}</td>
			<td>${persona.edad}</td>
			<td><a href="/ejemploSpringMVC/persona/edit/${persona.id}"><img alt="editar" src="/images/edit.png" width="20" height="20"></a></td>
			<td><a href="/ejemploSpringMVC/persona/delete/${persona.id}"><img alt="borrar" src="/images/delete.jpeg" width="20" height="20"></a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="/ejemploSpringMVC/persona/new"><spring:message code="persona.nueva" text="Persona nueva"/></a>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Datos de Persona</title>
</head>
<body>
	Idioma : <a href="?language=es">Español</a>|<a href="?language=eu_ES">Euskara</a>
	<spring:message code="datos.persona" text="Datos de Persona"/></br>
	<spring:message code="datos.persona.nombre" text="Name"/>: ${persona.nombre} </br>
	Apellido: ${persona.apellido}</br>
	Edad: ${persona.edad}</br>
	<a href="/ejemplo6/persona/new">Persona Nueva</a>
</body>
</html>
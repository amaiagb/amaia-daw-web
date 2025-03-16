<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.centrosanluis.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>
		HOLA,
		<c:out value="${usuario.nombre}"></c:out>
		(<c:out value="${usuario.rol.nombre}"></c:out>)
	</h1>
	<p>
		<a href="../listadoUsuarios">Listado Usuarios</a>
	</p>
	
	<c:if test="${usuario.rol.id == 1}">
		<p>
			<a href="../listadoRoles">Listado Roles</a>
		</p>
		<p>
			<a href="crearRol.jsp">Crear Rol</a>
		</p>
	</c:if>
	<p>
		<a href="../logout">Cerrar sesión</a>
	</p>
</body>
</html>
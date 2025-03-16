<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.centrosanluis.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>
</head>
<body>
	<h1>Usuarios</h1>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>Usuario</th>
			<th>Rol</th>
			<th></th>
		</tr>
		<c:if test="${listadoUsuarios != null}">
			<c:forEach var="u" items="${listadoUsuarios}">
			<tr>
				<td>
					<c:out value="${u.nombre}"></c:out>
				</td>
				<td>
					<c:out value="${u.apellidos}"></c:out>
				</td>
				<td>
					<c:out value="${u.email}"></c:out>
				</td>
				<td>
					<c:out value="${u.telefono}"></c:out>
				</td>
				<td>
					<c:out value="${u.usuario}"></c:out>
				</td>
				<td>
					<c:out value="${u.rol.nombre}"></c:out>
				</td>
				<td>
					<form action="iniciarRegistro" method="get">
						<input type="hidden" value="${u.usuario}" name="usuario">
						<button type="submit">Editar</button>
					</form>
					<form action="borrarUsuario" method="post">
						<input type="hidden" value="${u.usuario}" name="usuario">
						<button type="submit">Borrar</button>
					</form>
				</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
	<a href="private/index.jsp">Volver a index</a>
</body>
</html>
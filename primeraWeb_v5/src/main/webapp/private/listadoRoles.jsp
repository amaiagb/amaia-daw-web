<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.centrosanluis.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Roles</title>
</head>
<body>
	<table>
		<tr>
			<th>Nombre</th>
			<th></th>
		</tr>
			<c:forEach var="rol" items="${listadoRoles}">
				<tr>
					<td><c:out value="${rol.nombre}"></c:out> </td>
					<td>
						<form action="altaRol" method="get">
							<input type="hidden" value="${rol.id}" name="id">
							<button type="submit">Editar</button>
						</form>
						<form action="borrarRol" method="post">
							<input type="hidden" value="${rol.id}" name="id">
							<button type="submit">Borrar</button>
						</form>
					</td>
				</tr>
			</c:forEach>

	</table>
	<a href="private/index.jsp">Volver a index</a>
</body>
</html>
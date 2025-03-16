<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.centrosanluis.model.Usuario"%>
<%@page import="com.centrosanluis.model.Rol"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de usuario</title>
</head>
<body>
<div class="register-container">
	<h2>
		<c:choose>
			<c:when test="${usuario != null }">
				Editar usuario
			</c:when>
			<c:otherwise>
				Registrar nuevo usuario
			</c:otherwise>
		</c:choose>
	</h2>
	
	<c:choose>
		<c:when test="${usuario != null }">
			<form action="editarUsuario" method="post">
				<input type="text" name="nombre" value="${usuario.nombre}" placeholder="Nombre" required>
				<input type="text" name="apellidos" value="${usuario.apellidos}" placeholder="Apellidos" required>
				<input type="text" name="email" value="${usuario.email}" placeholder="Correo Electrónico" required>
				<input type="text" name="telefono" value="${usuario.telefono}" placeholder="Telefono" required>
				<input type="text" name="usuario" value="${usuario.usuario }" readonly placeholder="Usuario" required>
				<select id="rol" name="rol">
					<c:forEach var="r" items="${roles}">
						<option value="${r.id }">
							<c:out value="${r.nombre}"></c:out>
						</option>
					</c:forEach>
				</select>
			</form>
		</c:when>
		<c:otherwise>
			<form action="registro" method="post">
				<input type="text" name="nombre" value="" placeholder="Nombre" required>
				<input type="text" name="apellidos" value="" placeholder="Apellidos" required>
				<input type="text" name="email" value="" placeholder="Correo Electrónico" required>
				<input type="text" name="telefono" value="" placeholder="Telefono" required>
				<input type="text" name="usuario" value="" placeholder="Usuario" required>
				<input type="text" name="contrasena" placeholder="Contraseña" required>
				<select id="rol" name="rol">
					<c:forEach var="r" items="${roles}">
						<option value="${r.id }">
							<c:out value="${r.nombre}"></c:out>
						</option>
					</c:forEach>
				</select>
			</form>
		</c:otherwise>
	</c:choose>
		
		<button type="submit">
		 	<c:choose>
				<c:when test="${usuario != null }">
					Guardar cambios
				</c:when>
				<c:otherwise>
					Crear Usuario
				</c:otherwise>
			</c:choose>
		 </button>
	</form>
	<c:choose>
		<c:when test="${usuario != null }">
			<a href="private/index.jsp">Volver al index</a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp">Volver al login</a>
		</c:otherwise>
	</c:choose>
</div>
<script>
    <c:if test="${usuario != null}">
        document.getElementById("rol").value = "${usuario.rol.id}";
    </c:if>
</script>
</body>
</html>
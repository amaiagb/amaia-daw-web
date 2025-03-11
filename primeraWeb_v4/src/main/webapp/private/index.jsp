<%@page import="com.centrosanluis.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="../styles/styles.css">
</head>
<body>
<% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario"); %>
<h1>Hola, <%= usuario.getNombre() %>(<%= usuario.getRol().getNombre() %>)</h1>
<p class="username">@<%= usuario.getUsuario() %></p>

<a href="../listadoUsuarios">Listado de Usuarios</a>
<a href="../listadoUsuarios">Listado de Roles</a>

<% if(usuario.getRol().getId() == 1){ %>
	<p><a href="crearRol.jsp">Crear Rol</a></p>
<% } %>
</body>
</html>
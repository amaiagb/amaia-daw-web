<%@page import="com.centrosanluis.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% ArrayList<Usuario> listadoUsuarios = (ArrayList<Usuario>) request.getAttribute("listadoUsuarios");  %>

 <% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>
<link rel="stylesheet" href="http://localhost:8080/primeraWeb_v4/styles/styles.css">
</head>
<body>
<h1>Hola, <%= usuario.getNombre() %></h1>
<p class="username">@<%= usuario.getUsuario() %></p>
<table>
	<tr>
		<th>Nombre</th>
		<th>Apellidos</th>
		<th>Email</th>
		<th>Telefono</th>
		<th>Usuario</th>
		<th>Rol</th>
	</tr>
	 <% for (Usuario u : listadoUsuarios) {%>
	<tr>
		<td><%= u.getNombre() %></td>
		<td><%= u.getApellidos() %></td>
		<td><%= u.getEmail() %></td>
		<td><%= u.getTelefono() %></td>
		<td><%= u.getUsuario() %></td>
		<td><%= u.getRol().getNombre() %></td>
		<td><a href="deleteUser?user=<%=u.getUsuario() %>" >Eliminar</a></td>
	</tr>
	<%}%>
</table>
</body>
</html>
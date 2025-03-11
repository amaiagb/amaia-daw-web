<%@page import="com.centrosanluis.model.Usuario"%>
<%@page import="com.centrosanluis.model.Rol"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% ArrayList<Rol> roles = (ArrayList<Rol>) request.getAttribute("roles");  %>

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
		<th>Rol</th>
	</tr>
	 <% for (Rol r : roles) {%>
	<tr>
		<td><%= r.getNombre() %></td>

		<td>
		<form action="borrarRol">
			<button type="submit">Eliminar</button>
		</form>
		<a href="deleteUser?user=<%=r.getNombre() %>" >Eliminar</a></td>
	</tr>
	<%}%>
</table>
</body>
</html>
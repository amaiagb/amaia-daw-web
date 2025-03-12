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
	<h1>Hola, <%= usuario.getNombre() %> (<%= usuario.getRol().getNombre() %>)</h1>
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
		<%if(listadoUsuarios != null){ %>
			<%for(Usuario u : listadoUsuarios){ %>
				<tr>
					<td><%= u.getNombre() %></td>
					<td><%= u.getApellidos() %></td>
					<td><%= u.getEmail() %></td>
					<td><%= u.getTelefono() %></td>
					<td><%= u.getUsuario() %></td>
					<td><%= u.getRol().getNombre() %></td>
					<td>
						<form action="iniciarRegistro" method="get">
							<input type="hidden" value="<%= u.getUsuario() %>" name="usuario">
							<button type="submit">Editar</button>
						</form>
						<form action="borrarUsuario" method="post">
							<input type="hidden" value="<%= u.getUsuario() %>" name="usuario">
							<button type="submit">Borrar</button>
						</form>
					</td>
				</tr>
			<%} %>
		<%}else{ %>
			<tr>
				<td colspan="5">No hay usuarios</td>
			</tr>
		<%} %>
	</table>
</body>
</html>
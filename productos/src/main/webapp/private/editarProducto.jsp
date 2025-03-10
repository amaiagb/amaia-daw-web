<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.centrosanluis.productos.model.Producto"%>
<%@page import="com.centrosanluis.productos.model.Usuario"%>
<% 
    Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
    boolean admin; 
    if("admin".equalsIgnoreCase(usuario.getRol())){ admin = true;} else {admin = false;} 
%>
<% Producto p = (Producto)request.getSession().getAttribute("producto"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Producto</title>
<link href="../styles/styles.css" rel="stylesheet">
</head>
<body>
<header>
		<h2>Gestión de productos</h2>
		<a href="../logout" class="">Cerrar sesión</a>
	</header>
	<main>
		<h3>Hola, <%=usuario.getNombre() %></h3>
		<a href="index.jsp" class="btn">Volver</a>
		<h1>Editar producto</h1>
		
		<form action="../producto" method="post" id=formEditar>
		<input type="hidden" name="action" value="edit">
		<input type="hidden" name="id" value="<%= p.getId()%>">
		<input type="text" name="nombre" placeholder="Nombre de producto" required value="<%= p.getNombre()%>"><br>
		<input type="text" name="descripcion" placeholder="Descripción" value="<%= p.getDescripcion()%>"><br>
		<input type="text" name="precio" placeholder="Precio" required value="<%= p.getPrecio()%>"><br>
		<input type="text" name="stock" placeholder="Cantidad de stock" required value="<%= p.getStock()%>"><br>
		<button type="submit" class="btn">Guardar Producto</button>
		</form>
	</main>
</body>
</html>
<%@page import="com.centrosanluis.productos.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% 
	    Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
	    boolean admin; 
	    if("admin".equalsIgnoreCase(usuario.getRol())){ admin = true;} else {admin = false;} 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<link href="../styles/styles.css" rel="stylesheet">
</head>
<body>
	<header>
		<h2>Gestión de productos</h2>
		<a href="../logout" class="">Cerrar sesión</a>
	</header>
	<main>
		<h3>Hola, <%=usuario.getNombre() %></h3>
		<a href="../producto?action=show" class="btn">Ver productos</a>
		<% if(admin){ %>
			<a href="altaProducto.jsp" class="btn">Registrar nuevo producto</a>
		<%} %>
	</main>
</body>
</html>
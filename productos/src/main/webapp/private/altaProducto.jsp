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
<title>Registro de Productos</title>
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
		<h1>Registrar producto</h1>
		<form action="../producto" method="post" id=formRegistro enctype="multipart/form-data">
			<input type="hidden" name="action" value="add">
			<input type="text" name="nombre" placeholder="Nombre de producto" required><br>
			<input type="text" name="descripcion" placeholder="Descripción"><br>
			<input type="text" name="precio" placeholder="Precio" required><br>
			<input type="text" name="stock" placeholder="Cantidad de stock" required><br>
			<input type="file" name="imagen">
			<button type="submit" class="btn">Registrar Producto</button>
		</form>
	</main>
</body>
</html>
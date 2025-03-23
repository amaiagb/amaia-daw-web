<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="/tienda/styles/estilos.css">
</head>
<body>
<header>
		<nav>
			<a href="/tienda/inicio"><i class="fa-solid fa-house" style="color: #ffffff;"></i></a>
			<ul>
				<c:choose>
					<c:when test="${sessionScope.admin != null}">
						<li><a href="/tienda/gestionProductos">Gestionar Productos</a></li>
						<li><a href="/tienda/logout">Cerrar Sesión</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/tienda/login.jsp">Login</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/tienda/carrito"><i class="fas fa-cart-plus"></i> </a></li>
			</ul>
		</nav>
		<h1>Hola, ${admin.nombre}</h1>
	</header>
	
	<main id="altaProducto">
	
		<h2>Registrar Nuevo Producto</h2>
		
		<form action="../altaProducto" method="post" enctype="multipart/form-data">
			<input type="text" name="nombre"  placeholder="Nombre" required>
			<input type="text" name="descripcion"  placeholder="Descripción" required>
			<input type="text" name="precio"  placeholder="Precio" required>
			<input type="text" name="stock"  placeholder="Stock" required>
			<input type="file" name="imagen" id="file" accept="image/*">
			<button type="submit" class="btn btn-line">Registrar</button>
		</form>
		
	</main>
</body>
</html>
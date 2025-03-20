<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gesti�n de Productos</title>
</head>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="../styles/estilos.css">
</head>
<body>
	<header>
		<nav>
			<a href="inicio"><i class="fa-solid fa-house" style="color: #ffffff;"></i></a>
			<ul>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="carrito"><i class="fas fa-cart-plus"></i> </a></li>
			</ul>
		</nav>
		<h1>Hola, ${admin.nombre}</h1>
	</header>
	<main>
		<h2>Gesti�n de productos</h2>
		<a href="addProducto" class="">A�adir Producto</a>
		<a href="addProducto" class="">Editar Producto</a>
		<a href="" class="">Eliminar Producto</a>
	</main>
</body>
</html>
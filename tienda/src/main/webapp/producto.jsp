<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tienda</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="styles/estilos.css">
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
		<h1>${producto.nombre}</h1>
	</header>
	<main>
	
		<div id="detallado-container">
			<div class="detallado-img">
				<img alt="" src="resources/img/${producto.imagen}">
			</div>
			<div class="detallado-txt">
				<h2>${producto.nombre}</h2>
				<p>${producto.descripcion}</p>
				<p class="detallado-txt-precio">${producto.precio} €</p>
				<p class="detallado-txt-stock">Disponibles: ${producto.stock}</p>
				<form action="carrito" method="post">
					<input type="hidden" name="id" value="${producto.id}">
					<button type="submit" class="btn btn-fill">Comprar</button>
				</form>
			</div>			
		</div>
	</main>
	
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
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
		<h1>Carrito</h1>
	</header>
	<main>
		<div id="productos-container">
			<c:forEach var="producto" items="${carrito}">
				<div class="producto-card">
				<div class="producto-img">
					<img alt="" src="resources/img/${producto.key.imagen}">
				</div>
				<div class="producto-txt">
					<p class="producto-txt-nombre">${producto.key.nombre}</p>
					<p class="producto-txt-descripcion">${producto.key.descripcion}</p>
					<p class="producto-txt-precio">${producto.key.precio}<span>€</span></p>
					<p class="producto-txt-cantidad">Ud: ${producto.value}</p>
				</div>
				<div class="producto-links">
					<a href="producto?id=${producto.key}" class="btn btn-line">Detalles</a>
					<form action="carrito" method="post">
						<input type="hidden" name="id" value="${producto.value}">
						<button type="submit" class="btn btn-fill">Comprar</button>
					</form>
				</div>
			</div>
			</c:forEach>
		</div>
		<h3>Total: ${total} €</h3>
	</main>
</body>
</html>
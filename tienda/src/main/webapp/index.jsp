<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tienda</title>
 <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="/tienda/styles/estilos.css">
</head>
<body>
	<header>
		<nav>
			<a href="inicio"><i class="fa-solid fa-house" style="color: #ffffff;"></i></a>
			<ul>
				<c:choose>
					<c:when test="${sessionScope.admin != null}">
						<li><a href="gestionProductos">Gestionar Productos</a></li>
						<li><a href="logout">Cerrar Sesión</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="login.jsp">Login</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="carrito"><i class="fas fa-cart-plus"></i> </a></li>
			</ul>
		</nav>
		<h1>Productos</h1>
	</header>
	<main>
	<!--  
		<div>
			<form action="" method="post">
				<input type="text" name="" placeholder="Filtrar por nombre">
				<button>Filtrar</button>
			</form>
		</div>
		-->
		<div id="productos-container">
			<c:forEach var="producto" items="${productos}">
				<div class="producto-card">
				<div class="producto-img">
					<img alt="" src="resources/img/${producto.imagen}">
				</div>
				<div class="producto-txt">
					<p class="producto-txt-nombre">${producto.nombre}</p>
					<p class="producto-txt-descripcion">${producto.descripcion}</p>
					<p class="producto-txt-precio">${producto.precio}<span>€</span></p>
				</div>
				<div class="producto-links">
					<a href="producto?id=${producto.id}" class="btn btn-line">Detalles</a>
					<form action="carrito" method="post">
						<input type="hidden" name="id" value="${producto.id}">
						<button type="submit" class="btn btn-fill">Comprar</button>
					</form>
				</div>
			</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión de Productos</title>
</head>
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
	<main id="gestion_productos">
		<h2>Gestión de productos</h2>
		<a href="/tienda/private/altaProducto.jsp" class="btn btn-fill btn-add">Añadir Nuevo Producto</a>
		
		<table>
			<tr>
				<th>Imagen</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Precio</th>
				<th>Stock</th>
				<th></th>
				<th></th>
			</tr>
			<c:if test="${productos != null}">
				<c:forEach var="p" items="${productos}">
				<tr>
					<td>
						<img alt="" src="resources/img/${p.imagen}">
					</td>
					<td>
						<c:out value="${p.nombre}"></c:out>
					</td>
					<td>
						<c:out value="${p.descripcion}"></c:out>
					</td>
					<td>
						<c:out value="${p.precio}"></c:out>
					</td>
					<td>
						<c:out value="${p.stock}"></c:out>
					</td>
					<td>
						<form action="editarProducto" method="get">
							<input type="hidden" value="${p.id}" name="id">
							<button type="submit">Editar</button>
						</form>
					</td>
					<td>
						<form action="borrarProducto" method="post">
							<input type="hidden" value="${p.id}" name="id">
							<button type="submit">Borrar</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			</c:if>
		</table>
	</main>
</body>
</html>
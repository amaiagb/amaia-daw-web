<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
		<h1>Login</h1>
	</header>
	
	<main id="login">
		<form action="login" method="post" class="login">
			<input type="text" name="username" placeholder="Nombre de Usuario">
			<input type="password" name="password" placeholder="Contraseña">
			<button type="submit" class="btn btn-line">Entrar</button>
		</form>
	</main>
</body>
</html>
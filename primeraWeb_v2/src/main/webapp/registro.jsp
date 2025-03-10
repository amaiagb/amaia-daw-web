<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de usuario</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<div class="register-container">
	<h2>Registro de usuario</h2>
	<form action="registro" method="post">
		<input type="text" name="nombre" placeholder="Nombre" required>
		<input type="text" name="apellidos" placeholder="Apellidos" required>
		<input type="email" name="email" placeholder="Correo electronico" required>
		<input type="text" name="telefono" placeholder="Telefono" required>
		<input type="text" name="usuario" placeholder="Usuario" required>
		<input type="password" name="contrasena" placeholder="Contraseña" required>
		<button type="submit" class="btn">Registrarse</button>
	</form>
	<a href="login.jsp" class="btn2">Volver al login</a>
</div>
</body>
</html>

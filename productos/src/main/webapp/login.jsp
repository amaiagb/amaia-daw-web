<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar sesi�n</title>
<link href="styles/styles.css" rel="stylesheet">
</head>
<body>
<header>
		<h2>Gesti�n de productos</h2>
		<a href="../logout" class="">Cerrar sesi�n</a>
	</header>
	<main>
		<h3>Iniciar sesi�n</h3>
		
		<form action="login" method="post" id=formLogin>
		<input type="text" name="username" placeholder="Nombre de usuario" required><br>
		<input type="password" name="password" placeholder="Contrase�a" required><br>
		<button type="submit" class="btn">Entrar</button>
		</form>
		<% if(request.getParameter("error") != null) {%>
		<p>
			Usuario o contrase�a incorrecto
		</p>
		<%} %>
	</main>
</body>
</html>
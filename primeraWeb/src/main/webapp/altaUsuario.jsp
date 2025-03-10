<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Dar de alta Usuario</h2>
		<form action="altaUsuario" method="post">
			<input type="text" name="nombre" placeholder="Nombre">
			<input type="text" name="apellidos" placeholder="Apellidos"><br>
			<input type="text" name="telefono" placeholder="Telefono">
			<input type="text" name="email" placeholder="Email"><br>
			<input type="text" name="username" placeholder="Nombre de Usuario">
			<input type="password" name="password" placeholder="Contraseña"><br><br>
			<button type="submit">Dar de alta</button>
			<button type="reset">Borrar</button>
		</form>
		<% if(request.getParameter("error") != null) {%>
		<p>
			Introduce todos los datos correctamente
		</p>
		<%} %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<h1>Hola, <%=request.getSession().getAttribute("nombre")%></h1>
<p class="username">@<%=request.getSession().getAttribute("username")%></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.centrosanluis.productos.model.Usuario"%>
    <%@page import="com.centrosanluis.productos.model.Producto"%>
    <%@page import="java.util.ArrayList"%>
    <% 
	    Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
	    boolean admin; 
	    if("admin".equalsIgnoreCase(usuario.getRol())){ admin = true;} else {admin = false;} 
	    ArrayList<Producto> listado = (ArrayList) request.getSession().getAttribute("listado");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link href="../styles/styles.css" rel="stylesheet">
</head>
<body>
	<header>
		<h2>Gestión de productos</h2>
		<a href="../logout" class="">Cerrar sesión</a>
	</header>
	<main>
	<h3>Hola, <%=usuario.getNombre() %></h3>
	<a href="index.jsp" class="btn">Volver</a>
	<h1>Listado de productos</h1>
	<table>
		<tr>
			<th style="width: 25%">Nombre</th>
			<th style="width: 30%">Descripción</th>
			<th style="width: 10%">Precio</th>
			<th style="width: 10%">Stock</th>
			<th style="width: 15%">Imagen</th>
			<% if(admin){ %>
				<th style="width: 5%"></th>
				<th style="width: 5%"></th>
			<%} %>
		</tr>
		<% for(Producto p : listado){ %>
		<tr>
			<td><%=p.getNombre() %></td>
			<td><%=p.getDescripcion()%></td>
			<td><%=p.getPrecio()%></td>
			<td><%=p.getStock() %></td>
			<td><%=p.getImg_url() %></td>
			<% if(admin){ %>
				<td><a href="../producto?action=edit&id=<%=p.getId()%>">Editar</a></td>
				<td><a href="javascript:void(0);" onclick="mostrarModal(<%= p.getId() %>)">Eliminar</a></td>
				
			<%} %>
		</tr>
		<%} %>
	</table>
	<button>Anterior</button>
	<button>Siguiente</button>
	</main>
	<div id="modalEliminar">
		<p>Confirmar eliminación del producto</p>
		<form action="../producto" method="post" id="modalForm">
			<input type="hidden" name="action" value="delete">
			<input type="hidden" id="idProducto" name="id">
			<button type="submit" class="btn">Eliminar</button>
			<button type="button" class="btn" onclick="ocultarModal()">Cancelar</button>
		</form>
	</div>
	<script>
    function mostrarModal(id) {
    	console.log("Mostrar modal"); 
        document.getElementById('idProducto').value = id;
        document.getElementById('modalEliminar').style.display = "block";
    }

    function ocultarModal() {
    	console.log("Ocultar modal"); 
        document.getElementById('modalEliminar').style.display = "none";
    }
</script>
</body>
</html>

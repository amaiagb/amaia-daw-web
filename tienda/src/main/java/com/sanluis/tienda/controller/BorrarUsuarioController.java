package com.sanluis.tienda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanluis.tienda.model.Producto;
import com.sanluis.tienda.service.ProductoService;

@WebServlet("/borrarProducto")
public class BorrarUsuarioController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		productoService = new ProductoService();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		Producto producto = new Producto();
		
		producto.setId(id);
		
		if(productoService.borrarProducto(producto)) {
			
			response.sendRedirect("/tienda/gestionProductos");
		}else {
			/*
			List<Producto> listadoUsuarios = usuarioService.getUsers();
			
			request.setAttribute("listadoUsuarios", listadoUsuarios);
			request.setAttribute("error", "El usuario no ha podido darse de baja");
			
			request.getRequestDispatcher("private/listado.jsp").forward(request, response);
			*/
			response.sendRedirect("/tienda/gestionProductos");
		}
	}

}

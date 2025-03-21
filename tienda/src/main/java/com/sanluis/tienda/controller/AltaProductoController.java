package com.sanluis.tienda.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanluis.tienda.model.Producto;
import com.sanluis.tienda.service.ProductoService;

@WebServlet(name = "altaProducto", urlPatterns = { "/altaProducto" })
public class AltaProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ProductoService productoService;
	
    public AltaProductoController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    	productoService = new ProductoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double precio = Double.parseDouble(request.getParameter("telefono"));
		int stock = Integer.parseInt(request.getParameter("email"));
		String imagen = request.getParameter("imagen");
		
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setStock(stock);
		producto.setImagen(imagen);
		
		if(productoService.addProducto(producto)) {
			
		} else  {
			//Devolver al form y mostrar error
		}
		
	}

}

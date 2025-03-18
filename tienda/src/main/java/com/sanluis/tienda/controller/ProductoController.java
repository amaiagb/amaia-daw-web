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

@WebServlet(name = "producto", urlPatterns = { "/producto" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductoService productoService;  
	
    public ProductoController() {
        super();
         
    }

	public void init(ServletConfig config) throws ServletException {
		 productoService = new ProductoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int id = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoService.getProductoById(id);
		if(producto != null) {
			request.getSession().setAttribute("producto", producto);
			response.sendRedirect("producto.jsp");
		} else {
			response.sendRedirect("inicio");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}

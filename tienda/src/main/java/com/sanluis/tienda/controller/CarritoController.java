package com.sanluis.tienda.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanluis.tienda.model.Producto;
import com.sanluis.tienda.service.ProductoService;

/**
 * Servlet implementation class CarritoController
 */
@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService productoService;   
	
    public CarritoController() {
        super();
         
    }
    public void init(ServletConfig config) throws ServletException {
		 productoService = new ProductoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_producto = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoService.getProductoById(id_producto);
		
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) { 
			
			for(Cookie c : cookies) {
				if("carrito".equals(c.getName())) {
					String carrito_values = c.getValue();
					carrito_values.concat(", "+Integer.valueOf(id_producto));
					c.setValue(carrito_values);
					response.addCookie(c);
				} else { //no existe la cookie carrito
					Cookie cookie = new Cookie("carrito", "id_producto");
					response.addCookie(cookie);
				}
			}
		} else  { //no existe ninguna cookie
			Cookie cookie = new Cookie("carrito", "id_producto");
			response.addCookie(cookie);
		}
		
		response.sendRedirect("carrito.jsp");
	}

}

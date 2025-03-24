package com.sanluis.tienda.controller;

import java.io.IOException;
import java.util.HashMap;

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
		
		HashMap<Integer, Integer> productos_carrito = new HashMap<>();
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) { 
			for(Cookie c : cookies) {
				if("carrito".equals(c.getName())) {
					String carritoCookie  = c.getValue();
					
					HashMap<Producto, Integer> carritoUnidades = productoService.getProductosMap(carritoCookie);
					
 					double total = productoService.getTotal(carritoUnidades);
 					System.out.println(carritoUnidades);
					request.setAttribute("carrito", carritoUnidades);
					request.setAttribute("total", total);
				} 
			}
		} 
		
		//response.sendRedirect("carrito.jsp");
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_producto = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoService.getProductoById(id_producto);
		String id = request.getParameter("id");
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) { 
			
			for(Cookie c : cookies) {
				if("carrito".equals(c.getName())) {
					System.out.println("nueva cookie: "+id);
					
					String carrito_anterior = c.getValue();
					String nuevo_carrito = carrito_anterior.concat("?"+id);
					
					System.out.println(nuevo_carrito);
					c.setValue(nuevo_carrito);
					response.addCookie(c);
					
				} else { //no existe la cookie carrito
					Cookie cookie = new Cookie("carrito", id);
					cookie.setMaxAge(60*60*24);
					response.addCookie(cookie);
				}
			}
		} else  { //no existe ninguna cookie
			Cookie cookie = new Cookie("carrito", id);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
		response.sendRedirect("inicio");
	}
}

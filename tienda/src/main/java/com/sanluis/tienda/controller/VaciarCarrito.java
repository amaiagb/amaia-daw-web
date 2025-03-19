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

@WebServlet(name = "vaciarCarrito", urlPatterns = { "/vaciarCarrito" })
public class VaciarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService productoService;   
	
    public VaciarCarrito() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		productoService = new ProductoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) { 
			for(Cookie c : cookies) {
				if("carrito".equals(c.getName())) {
					c.setValue("");
					c.setMaxAge(0);
		            response.addCookie(c);
					
 					HashMap<Producto, Integer> carritoUnidades = productoService.getProductosMap(c.getValue());
 					double total = 0;
					request.setAttribute("carrito", carritoUnidades);
					request.setAttribute("total", total);
				} 
			}
		}
		response.sendRedirect("carrito.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HashMap<Integer, Integer> productos_carrito = new HashMap<>();
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) { 
			for(Cookie c : cookies) {
				if("carrito".equals(c.getName())) {
					String carrito  = c.getValue();
					String[] carrito_ids = carrito.split("\\?");
					
					for (String id : carrito_ids) {
                        int productoId = Integer.parseInt(id);
                        System.out.print(productoId+",");
                        productos_carrito.put(productoId, productos_carrito.getOrDefault(productoId, 0) + 1);
                    }
					
 					HashMap<Producto, Integer> carritoUnidades = productoService.getProductosCantidad(productos_carrito);
 					double total = productoService.getTotal(carritoUnidades);
					request.setAttribute("carrito", carritoUnidades);
					request.setAttribute("total", total);
				} 
			}
		} 
		//response.sendRedirect("carrito.jsp");
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

}

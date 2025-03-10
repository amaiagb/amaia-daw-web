package com.centrosanluis.productos.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.centrosanluis.productos.model.Producto;
import com.centrosanluis.productos.service.ProductoService;


@WebServlet(name = "producto", urlPatterns = { "/producto" })
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2,
		maxFileSize = 1024*1024*10,
		maxRequestSize = 1024*1024*15
		)
public class ProductoController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	ProductoService productoService;
	
    public ProductoController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		productoService = new ProductoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("show")) {
			ArrayList<Producto> productosObtenidos = productoService.getProductos();
			request.getSession().setAttribute("listado", productosObtenidos);
			response.sendRedirect("private/productos.jsp");
		}
		
		if(action.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Producto p = productoService.getProductoByID(id);
			request.getSession().setAttribute("producto", p);
			response.sendRedirect("private/editarProducto.jsp");
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if( action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			productoService.eliminarProducto(id);
			response.sendRedirect("private/index.jsp");
			
		} else {
			
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String precio = request.getParameter("precio");
			String stock = request.getParameter("stock");
			Part imagen = request.getPart("imagen"); 
		    String imagen_name = Paths.get(imagen.getSubmittedFileName()).getFileName().toString();
			
		    //File imageFile = new File(getServletContext().getRealPath("/img"), imagen_name);
		    File imageFile = new File("http://localhost:8080/productos/img/", imagen_name);
		    
	        try (InputStream input = imagen.getInputStream()) {
	            Files.copy(input, imageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);  // Guardar el archivo
	        }
		    
			Producto p = new Producto();
			p.setNombre(nombre);
			p.setDescripcion(descripcion);
			p.setPrecio(Double.parseDouble(precio));
			p.setStock(Integer.parseInt(stock));
			p.setImg_url(imagen_name);
			
			if(action.equals("add")) {
				productoService.registrarProducto(p);
				response.sendRedirect("private/index.jsp");
			}
			
			if(action.equals("edit")) {
				int id = Integer.parseInt(request.getParameter("id"));
				p.setId(id);
				
				productoService.editarProducto(p);
				response.sendRedirect("private/index.jsp");
			}
		}
		
		
	}

}

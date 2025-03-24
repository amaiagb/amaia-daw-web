package com.sanluis.tienda.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sanluis.tienda.model.Producto;
import com.sanluis.tienda.service.ProductoService;

@WebServlet(name = "altaProducto", urlPatterns = { "/altaProducto" })
@MultipartConfig(
	    fileSizeThreshold = 2097152,  // 2MB en bytes
	    maxFileSize = 10485760,       // 10MB en bytes
	    maxRequestSize = 52428800     // 50MB en bytes
	)

public class AltaProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ProductoService productoService;
	final String IMG_DIR = "/tienda/resources/img/";
	
    public AltaProductoController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	productoService = new ProductoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("nombre: "+request.getParameter("nombre"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		System.out.println("precio: "+request.getParameter("precio"));
		System.out.println("stock: "+request.getParameter("stock"));
		double precio = Double.valueOf(request.getParameter("precio"));
		int stock = Integer.valueOf(request.getParameter("stock"));
		//String img = request.getParameter("imagen");
		
		 // Manejo de la imagen
        Part imagenPart = request.getPart("imagen");
        
        // Obtiene el nombre original del archivo
        String imagenFileName = Paths.get(imagenPart.getSubmittedFileName()).getFileName().toString();
        
        // Define el directorio donde quieres guardar la imagen
        //String imagePath = getServletContext().getRealPath("/resources/img") + File.separator + imagenFileName;
      //String imagePath = IMG_DIR+ imagenFileName;
        String imagesDir = getServletContext().getRealPath("/resources/img");
        String imagePath = imagesDir + File.separator + imagenFileName;
        
        try {
            imagenPart.write(imagePath);
            System.out.println("Imagen guardada en: " + imagePath);
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("/tienda/altaProducto?error=true");  // Redirigir en caso de error
            return;
        }
        
        System.out.println(imagePath);
        // Guarda el archivo de la imagen en el servidor
        //imagenPart.write(imagePath);    	
    	//Producto nuevoProducto = new Producto(stock, precio, nombre, descripcion, imagePath);

		
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setStock(stock);
		producto.setImagen(imagenFileName);
		
		if(productoService.addProducto(producto)) {
			response.sendRedirect("/tienda/gestionProductos");
		} else  {
			//Devolver al form y mostrar error
		}
		
	}


}

package com.sanluis.tienda.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// Obtener los parámetros del producto (suponiendo que vienen en la solicitud)

        // Parsear cantidad y precio

        // Crear un objeto JSON para representar el producto

        // Obtener la cookie de carrito, si ya existe

        // Convertir el carrito de String a un ArrayList (o similar)

        // Agregar el nuevo producto a la lista

        // Convertir la lista de vuelta a JSON y guardarla en la cookie

        // Redirigir o responder
	}

}

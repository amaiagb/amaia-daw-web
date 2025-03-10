package com.centrosanluis.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.model.Usuario;
import com.centrosanluis.service.UsuarioService;

/**
 * Servlet implementation class ListadoController
 */
@WebServlet("/listadoUsuarios")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService;

	@Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	usuarioService = new UsuarioService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//llamo al service para obtener todos los usuarios
		ArrayList<Usuario> listadoUsuarios = usuarioService.getUsuarios();
		
		//añado en la request el atributo (no sesion) listado usuarios
		request.setAttribute("listadoUsuarios", listadoUsuarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/private/listado.jsp");
		dispatcher.forward(request, response);
		

	}


}

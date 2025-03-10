package com.centrosanluis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.service.UsuarioService;

/**
 * Servlet implementation class EliminarController
 */
@WebServlet(name = "deleteUser", urlPatterns = { "/deleteUser" })
public class EliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsuarioService usuarioService;
	
    public EliminarController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		usuarioService = new UsuarioService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		usuarioService.deleteUser(user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listadoUsuarios");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.centrosanluis.productos.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.productos.dao.UsuarioDAO;
import com.centrosanluis.productos.model.Usuario;
import com.centrosanluis.productos.service.UsuarioService;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService;
       
    public LoginController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		usuarioService = new UsuarioService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = new Usuario();
		usuario.setUsername(request.getParameter("username"));
		usuario.setPassword(request.getParameter("password"));
		
		Usuario usuarioLogin = usuarioService.login(usuario);
		
		if(usuarioLogin != null) {
			request.getSession().setAttribute("usuario", usuarioLogin);
			response.sendRedirect("private/index.jsp");
		} else {
			response.sendRedirect("login.jsp?error=1");
		}
	}

}

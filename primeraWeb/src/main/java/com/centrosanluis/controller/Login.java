package com.centrosanluis.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.bd.AccesoBDUsuarios;
import com.centrosanluis.model.Usuario;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, String> users = new HashMap<String, String>();
	
	public Login() {
		super();
		
	}
	
	@Override
	public void init(ServletConfig config)  throws ServletException{
		super.init(config);
		
		users.put("admin", "1234");
		users.put("usuario","password");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estoy entrando por get");
		/*
		 * PrintWriter out = response.getWriter();
		 */
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estoy entrando por post");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		try {
			AccesoBDUsuarios bd = new AccesoBDUsuarios();
			Usuario u = bd.getUsuarioPass(username, password);
			if(u != null ) {
				request.getSession().setAttribute("nombre",u.getNombre());
				request.getSession().setAttribute("apellidos",u.getApellidos());
				request.getSession().setAttribute("telefono",u.getTelefono());
				request.getSession().setAttribute("email",u.getEmail());
				request.getSession().setAttribute("usuario",u.getUsuario());
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("login.jsp?error=1");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		/*
		//version inicial
		if(users.containsKey(username) && users.get(username).equals(password)){
			response.sendRedirect("index.html");
		}else {
			//request.getSession().setAttribute("error", 1);
			response.sendRedirect("login.jsp?error=1");
		}
		*/
	}

}

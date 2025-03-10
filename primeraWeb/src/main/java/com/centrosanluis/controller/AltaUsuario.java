package com.centrosanluis.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.bd.AccesoBDUsuarios;
import com.centrosanluis.model.Usuario;


@WebServlet(name = "altaUsuario", urlPatterns = { "/altaUsuario" })
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AltaUsuario() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dando de alta usuario");
		
		//Recoger los datos introducidos en los campos del formulario
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");		
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		if(validarFormulario(nombre, apellidos, telefono, email, username, password)) {

			//Crear un Usuario con esos datos
			Usuario usuario = new Usuario(nombre, apellidos, telefono, email, username, password);
			
			try {
				//Persistir datos de usuario en BD
				AccesoBDUsuarios bd = new AccesoBDUsuarios();
				bd.addUsuario(usuario);
				
				//Crear sesión
				request.getSession().setAttribute("nombre",nombre);
				request.getSession().setAttribute("apellidos",apellidos);
				request.getSession().setAttribute("telefono",telefono);
				request.getSession().setAttribute("email",email);
				request.getSession().setAttribute("usuario",username);

				//Redirigir 
				response.sendRedirect("index.jsp");
							
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Datos incorrectos introducidos");
			response.sendRedirect("altaUsuario.jsp?error=1");
		}
		

		
		
	}
	private boolean validarFormulario(String nombre, String apellidos, String telefono, String email, String username,
			String password) {
		
		if(nombre.equals("")) {
			return false;
		}
		if(apellidos.equals("")) {
			return false;
		}
		if(telefono.equals("")) {
			return false;
		}
		if(email.equals("")) {
			return false;
		}
		if(username.equals("")) {
			return false;
		}
		if(password.equals("")) {
			return false;
		}
		
		return true;
	}


}

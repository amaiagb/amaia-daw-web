package com.centrosanluis.productos.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.productos.model.Usuario;


@WebFilter("/private/*")
public class AuthFilter implements Filter {

    public AuthFilter() {
       
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		String requestURI = req.getRequestURI();
		
		if(usuario == null ){
			resp.sendRedirect("../login.jsp");
			return;
		}
		
		if("admin".equalsIgnoreCase(usuario.getRol())) {
			chain.doFilter(request, response);
			
		} else if("usuario".equalsIgnoreCase(usuario.getRol())){
			
			if(requestURI.endsWith("/altaProducto.jsp") || requestURI.endsWith("/eliminarProducto.jsp")) {
				resp.sendRedirect("index.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void destroy() {
		
	}

}

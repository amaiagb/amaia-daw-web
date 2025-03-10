package com.centrosanluis.productos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.centrosanluis.productos.model.Usuario;

public class UsuarioDAO {
	
	Connection con = null; 
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Usuario login(Usuario usuarioLogin){
		
		con = AccesoBD.conectar();
		Usuario u = null;
		String sql = "SELECT nombre,username,rol FROM usuarios WHERE username=? AND password=?;";
				
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, usuarioLogin.getUsername());
			ps.setString(2, usuarioLogin.getPassword());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new Usuario();
				u.setNombre(rs.getString("nombre"));
				u.setUsername(rs.getString("username"));
				u.setRol(rs.getString("rol"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			AccesoBD.desconectar(rs, ps, con);
		}
		
		return u;
		
	}

}

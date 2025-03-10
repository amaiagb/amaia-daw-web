package com.centrosanluis.bd;

import java.sql.SQLException;

import com.centrosanluis.model.Usuario;

public class AccesoBDUsuarios extends AccesoBD{

	public AccesoBDUsuarios() throws ClassNotFoundException, SQLException {
		super(AccesoBD.DRIVER_MYSQL, "webapp", "root", "");
	}

	public Usuario getUsuarioPass(String username, String password) throws SQLException {
		
		String sql = "SELECT * FROM usuarios WHERE usuario= '"+username+"' AND password= '"+password+"'";
		rs = st.executeQuery(sql);
		
		if(rs.next()) {
			Usuario u = new Usuario(rs.getString("Nombre"), rs.getString("Apellidos"), rs.getString("Telefono"), rs.getString("Email"), rs.getString("Usuario"), rs.getString("Password"));
			return u;
		}
		return null;
	}

	public void addUsuario(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuarios VALUES('"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getTelefono()+"','"+usuario.getEmail()+"','"+usuario.getUsuario()+"','"+usuario.getPassword()+"');";
		st.execute(sql);
	}
	
}
package com.sanluis.tienda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sanluis.tienda.model.Admin;

public class AdminDAO {

	public Admin login(Admin admin) {
		
		Admin a = null;
		
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		String sql = "SELECT id, nombre, username, email FROM Administradores WHERE username=? AND password=?;";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,admin.getUsername());
			ps.setString(2, admin.getPassword());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				a = new Admin();
				a.setNombre(rs.getString("nombre"));
				a.setUsername(rs.getString("username"));
				a.setEmail(rs.getString("email"));
				a.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.closeConnection(rs, ps, con);
		}
		return a;
		
	}

	
	
}

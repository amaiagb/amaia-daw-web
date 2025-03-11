package com.centrosanluis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.centrosanluis.model.Rol;

public class RolDAO {

	public ArrayList<Rol> getRoles(){
		ArrayList<Rol> roles = new ArrayList<Rol>();
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, rol FROM roles;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Rol rol = new Rol();
				rol.setId(rs.getInt("id"));
				rol.setNombre(rs.getString("rol"));
				roles.add(rol);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.closeConnection(rs, ps, con);
		}
		System.out.println("DAO: "+roles);
		return roles;	
	}
	
	public Rol getRolesById(int id){
		Rol rol = new Rol();
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, nombre FROM roles WHERE id=?;";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				rol.setId(rs.getInt("id"));
				rol.setNombre(rs.getString("nombre"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.closeConnection(rs, ps, con);
		}
		return rol;	
	}
	
	public boolean createOrUpdateRol(Rol rol) {
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;

		String sql = "";
		
		if(rol.getId() != 0) {
			sql = "UPDATE roles SET rol = ? WHERE id = ?";
		} else {
			sql = "INSERT INTO roles (rol) VALUES (?)";
		}
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rol.getNombre());
			
			if(rol.getId() != 0) {
				ps.setInt(2, rol.getId());
			}
			
			if(ps.executeUpdate() > 0) {
				return true;
			}else {
				return false;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.closeConnection(null, ps, con);
		}
		return false;
	}


}

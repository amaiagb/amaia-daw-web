package com.centrosanluis.productos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBD {
	
	private static final String URL = "jdbc:mysql://localhost:3306/inventario";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void desconectar(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
			
			if(ps!=null) {
				ps.close();
			}
			
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

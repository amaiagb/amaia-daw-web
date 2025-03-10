package com.centrosanluis.productos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.centrosanluis.productos.model.Producto;
import com.centrosanluis.productos.model.Usuario;

public class ProductoDAO{
	
	public void registrarProducto(Producto producto) throws SQLException{
		Connection con = AccesoBD.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO producto(nombre, descripcion, precio, stock, imagen) VALUES(?,?,?,?,?);";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setString(3, String.valueOf(producto.getPrecio()));
			ps.setString(4,String.valueOf(producto.getStock()));
			ps.setString(5, producto.getImg_url());
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			AccesoBD.desconectar(null, ps, con);
		}
	}
	
	public ArrayList<Producto> getProductos() {
		
		Connection con = AccesoBD.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		String sql = "SELECT id, nombre, descripcion, precio, stock, imagen FROM producto;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(Double.parseDouble(rs.getString("precio")));
				p.setStock(Integer.parseInt(rs.getString("stock")));
				p.setImg_url(rs.getString("imagen"));
				productos.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.desconectar(rs, ps, con);
		}
		
		return productos;
	}

	public Producto getProductoByID(int id) {
		Connection con = AccesoBD.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto p = null;
		
		String sql = "SELECT id, nombre, descripcion, precio, stock, imagen FROM producto WHERE id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			String id_producto = String.valueOf(id);
			ps.setString(1, id_producto);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getInt("stock"));
				p.setImg_url(rs.getString("imagen"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.desconectar(rs, ps, con);
		}
		return p;
	}

	public void editarProducto(Producto p) {
		Connection con = AccesoBD.conectar();
		PreparedStatement ps = null;
		
		String sql = "UPDATE producto SET nombre=?, descripcion=?, precio=?, stock=? WHERE id=?;";
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getDescripcion());
			
			ps.setDouble(3, p.getPrecio());
			ps.setInt(4, p.getStock());
			ps.setInt(5, p.getId());
			
			int filasAfectadas = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.desconectar(null, ps, con);
		}
		
	}

	public void eliminarProducto(int id) {
		Connection con = AccesoBD.conectar();
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM producto WHERE id=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

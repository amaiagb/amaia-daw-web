package com.sanluis.tienda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sanluis.tienda.model.Producto;

public class ProductoDAO {

	
	public ArrayList<Producto> getProductos() {
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		String sql = "SELECT id, nombre, descripcion, precio, stock, imagen FROM productos ORDER by id DESC;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getInt("stock"));
				p.setImagen(rs.getString("imagen"));
				productos.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.closeConnection(rs, ps, con);
		}
		
		
		
		return productos;
	}

	public Producto getProductoById(int id) {
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto p = null;
		
		String sql = "SELECT id, nombre, descripcion, precio, stock, imagen FROM productos WHERE id=?;";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getInt("stock"));
				p.setImagen(rs.getString("imagen"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.closeConnection(rs, ps, con);
		}
		
		
		return p;
	}

	public HashMap<Producto, Integer> getProductosCantidad(HashMap<Integer, Integer> productos_carrito) {

		HashMap<Producto, Integer> carrito  = new HashMap<Producto, Integer>();
		
		productos_carrito.forEach( (id, ud) -> {
			Producto p = getProductoById(id);
			carrito.put(p, ud);
		});
		
		return carrito;
	}
	
	public boolean addProducto(Producto producto) {
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO productos(nombre, descripcion, precio, stock, imagen) VALUES(?,?,?,?,?);";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setDouble(3, producto.getPrecio());
			ps.setInt(4, producto.getStock());
			ps.setString(5, producto.getImagen());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean borrarProducto(Producto producto) {
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM productos WHERE id = ?;";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, producto.getId());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}

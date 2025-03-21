package com.sanluis.tienda.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sanluis.tienda.DAO.AccesoBD;
import com.sanluis.tienda.DAO.ProductoDAO;
import com.sanluis.tienda.model.Producto;

public class ProductoService {
	
	ProductoDAO productoDAO = new ProductoDAO();

	public ArrayList<Producto> getProductos() {
		
		return productoDAO.getProductos();
	}

	public Producto getProductoById(int id) {
		return productoDAO.getProductoById(id);
	}
	
	public HashMap<Producto, Integer> getProductosMap(String cookie) {
		HashMap<Producto, Integer> productosCantidadMap = null;
		HashMap<Integer, Integer> idsCantidadMap = null;
		
		if(!"".equals(cookie)) {
			String[] carrito_ids = cookie.split("\\?");
			productosCantidadMap = new HashMap<Producto, Integer>();
			idsCantidadMap = new HashMap<Integer, Integer>();
			
			for (String id : carrito_ids) {
	            int productoId = Integer.parseInt(id);
	            idsCantidadMap.put(productoId, idsCantidadMap.getOrDefault(productoId, 0) + 1);
	        }
			
			 for (Map.Entry<Integer, Integer> entry : idsCantidadMap.entrySet()) {
	            int id = entry.getKey();
	            int cantidad = entry.getValue();
	            Producto p = productoDAO.getProductoById(id);
                if (p != null) {
                    productosCantidadMap.put(p, cantidad); 
                }
	        }

			/* error
			idsCantidadMap.forEach( (id, ud) -> {
				Producto p = productoDAO.getProductoById(id);
				productosCantidadMap.put(p, ud);
			});
			*/
		}
		return productosCantidadMap;
	}

	

	public double getTotal(HashMap<Producto, Integer> carritoUnidades) {
	    double total = 0;

	    for (Map.Entry<Producto, Integer> entry : carritoUnidades.entrySet()) {
	        Producto p = entry.getKey();
	        int ud = entry.getValue();
	        total += p.getPrecio() * ud;
	    }

	    return total;
	}
	
	
	public HashMap<Producto, Integer> getProductosCantidad(HashMap<Integer, Integer> productos_carrito) {
			
			return productoDAO.getProductosCantidad(productos_carrito);
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}

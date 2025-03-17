package com.sanluis.tienda.model;

public class Admin {
	
	private String nombre, username, email;
	private int id;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Admin [nombre=" + nombre + ", username=" + username + ", email=" + email + ", id=" + id + "]";
	}
	
	

}

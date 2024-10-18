package com.item.modelo;

public class Producto {
	
	private int id;
	private String nombre;
	private Double precio;
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int id, String nombre, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

}

package com.item.modelo;

public class Item {

	private Producto producto;
	private Integer cantidad;

	public Item() {
		super();
	}

	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotalProducto() {
		return producto.getPrecio() * cantidad.doubleValue();
	}
}

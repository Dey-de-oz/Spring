package com.deydeoz.springboot.web.app.modelos;

public class DetalleV {
	private String fkVenta;
	private String producto;
	private double precio;
	public DetalleV() {
		
	}
	public DetalleV(String fkVenta, String producto, double precio) {
		
		this.fkVenta = fkVenta;
		this.producto = producto;
		this.precio = precio;
	}
	public String getFkVenta() {
		return fkVenta;
	}
	public void setFkVenta(String fkVenta) {
		this.fkVenta = fkVenta;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}

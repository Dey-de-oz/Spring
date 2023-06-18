package com.deydeoz.springboot.di.app.models.domain;

public class Producto {
	private String nombreP;
	private double precio;

	public Producto(String nombreP, double precio) {
		
		this.nombreP = nombreP;
		this.precio = precio;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}

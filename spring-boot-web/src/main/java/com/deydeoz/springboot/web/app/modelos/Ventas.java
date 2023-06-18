package com.deydeoz.springboot.web.app.modelos;

public class Ventas {
	private String IdVentas;
	private String IdCliente;
	private double TotalVenta;

	public Ventas() {

	}

	public Ventas(String idVentas, String idCliente, double totalVenta) {
		IdVentas = idVentas;
		IdCliente = idCliente;
		TotalVenta = totalVenta;
	}

	public String getIdVentas() {
		return IdVentas;
	}

	public void setIdVentas(String idVentas) {
		IdVentas = idVentas;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public double getTotalVenta() {
		return TotalVenta;
	}

	public void setTotalVenta(float totalVenta) {
		TotalVenta = totalVenta;
	}

}

package com.deydeoz.springboot.di.app.models.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Factura {
@Value("${factura.descripcion}")
private String descripcion;
@Autowired
private Cliente cliente;
@Autowired
private List<ItemFactura> item;
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public List<ItemFactura> getItem() {
	return item;
}
public void setItem(List<ItemFactura> item) {
	this.item = item;
}
@PostConstruct // Anotación que sirve para indicar una acción antes de que se cree un objeto dentro de otra clase por medio de inyección de dependencias
public void postConstruct() {
	//Ejemplo de anotación post construct
	//Esta función se ejectutara cuando antes de que se cree un objeto de tipo Factura
	cliente.setNombre(cliente.getNombre().concat(" Andres"));
	cliente.setApellido(cliente.getApellido().concat(" de la Goya y Goya"));
	descripcion = descripcion.concat(" del cliente");
}

}
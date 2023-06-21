package com.deydeoz.springboot.di.app.models.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
/*
 * Tipos de scope:
 * 
 * @RequestScope:
 * Hace que el contexto del controlador que se está macando dure lo que dura la petición HTTP
 * Por lo tanto, cada que se cree el objeto sus atributos PostConstruct y PreDestroy
 * Se ejecutarán hasta que cerremos la vista asociada al controlador.
 * 
 * @SessionScope
 * Se utiliza para guardar datos de una sesión, tales como un carrito de compras.
 * Los datos persisten aun cuando la petición HTTP ha finalizado. La sesión se destruye
 * una vez que se cierra el navegador.
 * */
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
	//Esta función se ejectutara antes de que se cree un objeto de tipo Factura
	cliente.setNombre(cliente.getNombre().concat(" Andres"));
	cliente.setApellido(cliente.getApellido().concat(" de la Goya y Goya"));
	descripcion = descripcion.concat(" del cliente");
}

}

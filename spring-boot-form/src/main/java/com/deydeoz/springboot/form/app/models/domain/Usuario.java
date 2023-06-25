package com.deydeoz.springboot.form.app.models.domain;

import jakarta.validation.constraints.NotEmpty;

/*
 * Las clases modelo son clases para crear objetos orientados a la logica de negocio los cuales permiten
 * manejar de una mejor manera los datos. Ademas permiten el uso de los metodos contenidos en la clase 
 * directamente en las vistas a travez de un controlador que envie el objeto por medio de Thymeleaf
 * */
public class Usuario {
	/*
	 * Como cualquier clase que se va a implementar como manejo de objetos  se deben de crear sus atributos
	 * privados, asi como un constructor para inicializar las variables.
	 * 
	 * Para las clases que se utilizan solo para construir un objeto para despues guardarlo en una base de datos
	 * no es necesario inyectarlos. Ya que la ifnormación al final se guarda en otro lado.
	 * */
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String password;
	@NotEmpty
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * ANOTACIONES DE SPRING
	 * 
	 * @NotEmpty: Es una regla de validacion predefinida y construida por Spring para indicar que un valor no
	 * puede estar vacio. Esto se utiliza con: mapeo de datos.
	 * */
}

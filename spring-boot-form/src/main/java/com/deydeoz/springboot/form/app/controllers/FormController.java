package com.deydeoz.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller //Anotacion para indicar que es una clase controladora
public class FormController {
	
	/*
	 * Para el mapeo de los datos con controladores se deben crear dos metodos
	 * que manejaran los datos. Un metodo que envia los datos al controlador
	 * el cual será un metodo GET (GetMapping) y un metodo para recibir los
	 * datos de la vista, manejados por un metodo POST (PostMapping)
	 * */
	@GetMapping("/formulario") //Anotación para enviar datos por metodo GET. Dentro se ke asigna una ruta para acceder a ese metodo desde el navegador
	public String enviarDatos(Model model) { //Model permite modificar los datos de la vista
		return "form"; //La función devuelve la ruta de la vista. 
	}
	@PostMapping("/formData") //Anotacion para indicar que se reciben datos por metodo POST
	public String recibirDatos(HttpServletRequest request, Model model) {
		//Función HttpServletRequest sirve para obtener multiples parametros sin tener que definirlos
		String nombre = request.getParameter("Iname");
		String pass = request.getParameter("Ipass");
		
		/*
		 * Se utiliza la fncion addAttribute() para enviar datos a la vista
		 * */
		model.addAttribute("usuario", nombre);
		model.addAttribute("password", pass);
		return "resultado";//Devuelve una vista con la respuesta
	}

}

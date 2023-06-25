package com.deydeoz.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.deydeoz.springboot.form.app.models.domain.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller //Anotacion para indicar que es una clase controladora
@SessionAttributes("usuario") //Anotacion para mantener datos
public class FormController {
	
	/*
	 * Para el mapeo de los datos con controladores se deben crear dos metodos
	 * que manejaran los datos. Un metodo que envia los datos al controlador
	 * el cual será un metodo GET (GetMapping) y un metodo para recibir los
	 * datos de la vista, manejados por un metodo POST (PostMapping)
	 * */
	@GetMapping("/formulario") //Anotación para enviar datos por metodo GET. Dentro se ke asigna una ruta para acceder a ese metodo desde el navegador
	public String enviarDatos(Model model) { //Model permite modificar los datos de la vista
		Usuario user = new Usuario();
		user.setUsername("User01");
		user.setId(23);
		model.addAttribute("usuario", user);
		return "form"; //La función devuelve la ruta de la vista. 
	}
	@PostMapping("/formData") //Anotacion para indicar que se reciben datos por metodo POST
	public String recibirDatos(HttpServletRequest request, Model model) {
		//Función HttpServletRequest sirve para obtener multiples parametros sin tener que definirlos
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("password");
		Usuario user = new Usuario();
		
		user.setNombre(nombre);
		user.setPassword(pass);
		/*
		 * Se utiliza la fncion addAttribute() para enviar datos a la vista
		 * */
		model.addAttribute("usuario", user);
		model.addAttribute("titulo", "Recepcion de datos normal");
		return "resultado";//Devuelve una vista con la respuesta
	}
	@PostMapping("/formData2") //Anotacion para indicar que se reciben datos por metodo POST
	
	public String recibirDatos2(@Valid Usuario user,BindingResult result, Model model, SessionStatus status) {
		
		/*
		 * Mapeo de datos desde la vista. En esta caso, la obtención de los datos contenidos ya en un 
		 * objeto viene directamente de la vista. Ya solo se recibe como parametro el objeto ya construido.
		 * Para consultar los datos mapeados se pasa como parametro un objeto de la clase a la que vamos a
		 * hacer erferencia.
		 * */
		
		//Validar si hay errores
		if(result.hasErrors()) {
			
			//Crear un arreglo para guardar cada uno de los errores detectados
			
			 /*Esta funcionalidad se utiliza en caso de no usar los atributos object de Thymeleaf
			Map<String,String> errores = new HashMap<>(); 
			result.getFieldErrors().forEach(err ->{
				//Se itera la lista de errores para obtener la informacion
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);*/
			return "form";
		}
		
		model.addAttribute("usuario", user);
		model.addAttribute("titulo", "Recepcion de datos con mapeo de clase");
		status.setComplete();//Indica que los datos ya han sido utilizados y pueden dejar de utilizarse
		return "resultado";//Devuelve una vista con la respuesta
	}
	/*
	 * ANOTACIONES DE SPRING
	 * 
	 * @Valid : Es una anotación para el controlador, y se usa para realizar la validacion de los datos obtenidos
	 * por medio de el mapeo de clase desde la vista. En este lado del controlador, solo se usa esta anitacion
	 * las reglas de validacion se realizan dentro de la clase que s eva a validar.
	 * 
	 * BindingResult: Interfaz predefinida por Spring la cual obtiene los resultados de las validaciones
	 * realizadas por la anotacion @Valid. Este parametro siempre debe de escribirse despues del 
	 * objeto que se esta mapeando.
	 * 
	 * Metodo .getFieldErrors(): Es un metodo de BindingResult que devuelve una lista de errores
	 * 
	 * @SessionAttributes: Es una anotacion para mantener datos que vayan precargados desde el controlador
	 * a la vista. Los datos se mantienen hasta que sucede una accion predeterminada. Esta accion predeterminada
	 * se ejecuta utilizando el parametro SessionStatus, el cual es una interfaz de clase con el cual
	 * se puede acceder a la modificacion de los estatus de las sesiones definidas. Para co mpletar el
	 * ciclo de vida de atributos de seson se utiliza e metodo . setComplete() el cual indica que 
	 * ha finalizado la sesion
	 * */

}

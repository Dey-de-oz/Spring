package com.deydeoz.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deydeoz.springboot.di.app.models.service.IService;



@Controller
public class indexController {
	//private Service servicio = new Service(); Se utiliza sin inyeccion de dependencias
	@Autowired  //Anotación para inyectar una dependencia
	@Qualifier("ServiceSimple")
	private IService servicio; //Un objeto de la clase inyectada
	@GetMapping({"/","/index"})
	public String index(Model model) {
		model.addAttribute("inyeccion", servicio.operacion());
		return "/index";
	}
}

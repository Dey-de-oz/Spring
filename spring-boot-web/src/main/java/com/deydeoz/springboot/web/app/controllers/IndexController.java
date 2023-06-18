package com.deydeoz.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.deydeoz.springboot.web.app.modelos.Usuarios;


@Controller 
@RequestMapping("/control")
public class IndexController {
	@GetMapping(value = {"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Controlador funciona!!");
		model.addAttribute("confirma", "Función funciona funcionalmente funcionando!!");
		return "index";
	}
	
	@GetMapping(value={"/perfil","/profile"})
	public String perfil(Model model) {
		Usuarios usuario = new Usuarios();
		usuario.setNombre("David");
		usuario.setApellido("Morales");
		usuario.setCorreo("david.correo@gmail");
		model.addAttribute("titulo", "Perfil de" .concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	@GetMapping(value="/listar")
	public String listado(Model model) {
		/*
		List<Usuarios> lista = new ArrayList<>();
		lista.add(new Usuarios("David","Morales","correo1@gmail.com"));
		lista.add(new Usuarios("Leti","Cornelio","correo2@gmail.com"));
		lista.add(new Usuarios("Rosario","Carrillo","correo2@gmail.com"));
		*/
		model.addAttribute("titulo", "Usuarios registrados");
		//model.addAttribute("usuarios", lista);
		return "listar";
	}
	//Con este metodo y el decorador, se puede acceder a los datos
	// Desde cualquier vista que tenga relación con este controlador
	@ModelAttribute("usuarios")
	public List<Usuarios> get_usuarios(){
		List<Usuarios> lista = new ArrayList<>();
		lista.add(new Usuarios("David","Morales","correo1@gmail.com"));
		lista.add(new Usuarios("Leti","Cornelio","correo2@gmail.com"));
		lista.add(new Usuarios("Rosario","Carrillo","correo2@gmail.com"));
		return lista;
	}
	
}

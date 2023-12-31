package com.deydeoz.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjParamsController {
	
@GetMapping("/string")
public String params(@RequestParam(name= "texto", defaultValue = "No hay texto") String texto,Model model) {
	model.addAttribute("titulo","Pasando parametros");
	model.addAttribute("resultado", "El texto ingresado es : " + texto);
	return "params/ver";
}
}

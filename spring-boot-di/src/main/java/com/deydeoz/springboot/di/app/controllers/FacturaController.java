package com.deydeoz.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deydeoz.springboot.di.app.models.domain.Factura;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
	@Autowired
	private Factura factura;
	@GetMapping("/ver")
	public String verFactura(Model model) {
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "VISUALIZACIÓN DE FACTURAS CON INYECCIÓN DE DEPENDENCIAS");
		return "factura/ver";
	}

}

package com.deydeoz.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import com.deydeoz.springboot.web.app.modelos.Usuarios;
import com.deydeoz.springboot.web.app.modelos.Ventas;

import jakarta.servlet.http.HttpServletRequest;

import com.deydeoz.springboot.web.app.modelos.DetalleV;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value= {"/sales"})
public class VentasController {
	//Request
	@GetMapping("/")
	public String ventas(Model model) {
		/*
		 * Devuelve una lista de las ventas relizadas
		 * */
		
		model.addAttribute("titulo", "Ventas por cliente");
		return("ventas/ov_mst");
	}
/*	@GetMapping("/detalle")
	public String detalle(@RequestParam(name="ov_id") String ov_id,Model model) {

		//Consultar o definir las ordenes de venta
		List<Ventas> ov_list = new ArrayList<>();
		ov_list.add(new Ventas("OV001","David",30.0));
		ov_list.add(new Ventas("OV002","Leti",10.0));
		ov_list.add(new Ventas("OV003","Leti",20.0));
		ov_list.add(new Ventas("OV004","Rosario",10.0));
		ov_list.add(new Ventas("OV005","David",10.0));
		ov_list.add(new Ventas("OV006","PacoWeb",100.0));
		
		
		//Consultar o definir el detalle de cada una de las OV
		List<DetalleV> detalle = new ArrayList<>();
		detalle.add(new DetalleV("OV001","Agua",15.0));
		detalle.add(new DetalleV("OV001","Papas",15.0));
		detalle.add(new DetalleV("OV002","Chicle",5.0));
		detalle.add(new DetalleV("OV002","Paleta",5.0));
		detalle.add(new DetalleV("OV003","Cheetos",10.0));
		detalle.add(new DetalleV("OV003","Jugo",10.0));
		detalle.add(new DetalleV("OV004","Chicle",5.0));
		detalle.add(new DetalleV("OV004","Dulce",5.0));
		detalle.add(new DetalleV("OV005","Dulce",5.0));
		detalle.add(new DetalleV("OV005","Sacapuntas",5.0));
		detalle.add(new DetalleV("OV006","Pizza",100.0));
		
		List<DetalleV> detalle2 = new ArrayList<>();
		for(DetalleV value : detalle) {
			String id = value.getFkVenta();
			//7System.out.print(id);
			//System.out.print(ov_id);
			if(id.equals(ov_id)) {
				detalle2.add(value);
				//System.out.print("Correcto" + "\n");
			}
		}
		model.addAttribute("titulo", "Detalle de OV " + ov_id);
		model.addAttribute("detalle", detalle2);
		
		return "/ventas/ovd_det";
	}*/
	@GetMapping("/detalle")
	public String detalle(HttpServletRequest request,Model model) {
		//Dunción HttpServletRequest sirve para obtener multiples parametros 
		String ov_id = request.getParameter("ov_id");//Con el objeto request se pueden obtener los datos recibidos
		String cus = request.getParameter("cliente");
		double total = Double.parseDouble(request.getParameter("total"));
		//Consultar o definir las ordenes de venta
		List<Ventas> ov_list = new ArrayList<>();
		ov_list.add(new Ventas("OV001","David",30.0));
		ov_list.add(new Ventas("OV002","Leti",10.0));
		ov_list.add(new Ventas("OV003","Leti",20.0));
		ov_list.add(new Ventas("OV004","Rosario",10.0));
		ov_list.add(new Ventas("OV005","David",10.0));
		ov_list.add(new Ventas("OV006","PacoWeb",100.0));
		
		
		//Consultar o definir el detalle de cada una de las OV
		List<DetalleV> detalle = new ArrayList<>();
		detalle.add(new DetalleV("OV001","Agua",15.0));
		detalle.add(new DetalleV("OV001","Papas",15.0));
		detalle.add(new DetalleV("OV002","Chicle",5.0));
		detalle.add(new DetalleV("OV002","Paleta",5.0));
		detalle.add(new DetalleV("OV003","Cheetos",10.0));
		detalle.add(new DetalleV("OV003","Jugo",10.0));
		detalle.add(new DetalleV("OV004","Chicle",5.0));
		detalle.add(new DetalleV("OV004","Dulce",5.0));
		detalle.add(new DetalleV("OV005","Dulce",5.0));
		detalle.add(new DetalleV("OV005","Sacapuntas",5.0));
		detalle.add(new DetalleV("OV006","Pizza",100.0));
		
		List<DetalleV> detalle2 = new ArrayList<>();
		for(DetalleV value : detalle) {
			String id = value.getFkVenta();
			//7System.out.print(id);
			//System.out.print(ov_id);
			if(id.equals(ov_id)) {
				detalle2.add(value);
				//System.out.print("Correcto" + "\n");
			}
		}
		model.addAttribute("titulo", "Detalle de venta: " + ov_id);
		model.addAttribute("detalle", detalle2);
		model.addAttribute("cliente", cus);
		model.addAttribute("total", total);
		
		return "/ventas/ovd_det";
	}
	
	//Modelos
	@ModelAttribute("usuarios")
	public List<Usuarios> get_usuarios(){
		List<Usuarios> lista = new ArrayList<>();
		lista.add(new Usuarios("David","Morales","correo1@gmail.com"));
		lista.add(new Usuarios("Leti","Cornelio","correo2@gmail.com"));
		lista.add(new Usuarios("Rosario","Carrillo","correo2@gmail.com"));
		return lista;
	}
	@ModelAttribute("lventas")
	public List<Ventas> get_ventas(){
		List<Ventas> ov_list = new ArrayList<>();
		ov_list.add(new Ventas("OV001","David",30.0));
		ov_list.add(new Ventas("OV002","Leti",10.0));
		ov_list.add(new Ventas("OV003","Leti",20.0));
		ov_list.add(new Ventas("OV004","Rosario",10.0));
		ov_list.add(new Ventas("OV005","David",10.0));
		ov_list.add(new Ventas("OV006","PacoWeb",100.0));
		return ov_list;
	}
}

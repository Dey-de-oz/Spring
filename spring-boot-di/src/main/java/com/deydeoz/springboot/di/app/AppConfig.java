package com.deydeoz.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deydeoz.springboot.di.app.models.domain.ItemFactura;
import com.deydeoz.springboot.di.app.models.domain.Producto;

@Configuration
public class AppConfig {

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto prod1 = new Producto("Mouse alambrico", 119);
		Producto prod2 = new Producto("Mouse inalambrico", 90);
		
		ItemFactura linea1 = new ItemFactura(prod1, 2);
		ItemFactura linea2 = new ItemFactura(prod2, 5);
		
		return Arrays.asList(linea1,linea2); // Sustituto de metodo .add() para agregar elementos al list
	}
}

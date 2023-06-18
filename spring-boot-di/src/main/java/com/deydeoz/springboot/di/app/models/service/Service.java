package com.deydeoz.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

@Component("ServiceSimple")
public class Service implements IService{
	@Override
	public String operacion() {
		return "Se ejecuta desde una inyección de datos con servicio simple";
	}
}

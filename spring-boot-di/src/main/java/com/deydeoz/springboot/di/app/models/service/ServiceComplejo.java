package com.deydeoz.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("ServiceComplejo")//El nombre dentro del parentesis sirve para identificaral componente en una inyeccion
@Primary //Define un componente por defecto a la hora de inyectar por medio de interface
public class ServiceComplejo implements IService {
	@Override
	public String operacion() {
		return "Se ejecuta desde una inyección de datos con servicio complejo";
	}
}

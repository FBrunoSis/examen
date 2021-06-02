package com.fbruno.prueba.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fbruno.prueba.dominio.Opcional;
import com.fbruno.prueba.logica.OpcionalServicio;

@RestController
@RequestMapping("/opcionales")
public class OpcionalController {
	@Autowired
	private OpcionalServicio servicio;

	@RequestMapping
	public List<Opcional> listarTodos() {
		return servicio.listarTodos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	//@PostMapping
	public ResponseEntity<Opcional> guardar(@RequestBody Opcional p) {
		Opcional opcional = servicio.guardar(p);
		try {
			return ResponseEntity.created(new URI("/opcionales"+opcional.getId())).body(opcional);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}

package com.fbruno.prueba.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fbruno.prueba.dominio.Automovil;
import com.fbruno.prueba.logica.AutomovilServicio;

@RestController
@RequestMapping("/automoviles")
public class AutomovilController {
	
	@Autowired
	private AutomovilServicio servicio;
	
	@RequestMapping
	public List<Automovil> listarTodos() {
		return servicio.listarTodos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Automovil> guardar(@RequestBody Automovil p) {
		Automovil auto = servicio.guardar(p);
		try {
			return ResponseEntity.created(new URI("/automoviles"+auto.getId())).body(auto);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Automovil actualizar(@RequestBody Automovil i) {
		return servicio.actualizar(i);
	}
	
	@RequestMapping(value = "/{ID}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(name = "ID") Integer id) {
		servicio.eliminar(id);
	}
	
	@RequestMapping(value = "/{ID}/{ID_OP}")	
	public Automovil asignarOpcional(@PathVariable(name = "ID") Integer id,@PathVariable(name = "ID_OP") Integer idop) {
		return servicio.asignarOpcional(id,idop);
	}
}

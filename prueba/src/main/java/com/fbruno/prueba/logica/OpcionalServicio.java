package com.fbruno.prueba.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbruno.prueba.dominio.Opcional;
import com.fbruno.prueba.persistencia.OpcionalRepositorio;

@Service
public class OpcionalServicio {
	@Autowired
	private OpcionalRepositorio repositorio;
	
	public List<Opcional> listarTodos() {
		return repositorio.findAll();
	}

	public Opcional guardar(Opcional p) {
		return repositorio.save(p);
	}
}

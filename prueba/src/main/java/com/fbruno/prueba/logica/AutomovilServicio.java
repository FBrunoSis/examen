package com.fbruno.prueba.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbruno.prueba.dominio.Automovil;
import com.fbruno.prueba.dominio.Opcional;
import com.fbruno.prueba.persistencia.AutomovilRepositorio;
import com.fbruno.prueba.persistencia.OpcionalRepositorio;


@Service
public class AutomovilServicio {
	@Autowired
	private AutomovilRepositorio repositorio;
	@Autowired
	private OpcionalRepositorio repositorioOpcional;
	
	public List<Automovil> listarTodos() {
		return repositorio.findAll();
	}

	public Automovil guardar(Automovil p) {
		return repositorio.save(p);
	}
	
	public Automovil actualizar(Automovil i) {
		return repositorio.save(i);
	}
	
	public Automovil asignarOpcional(Integer i, Integer o) {
		double total = 0;
		Automovil auto = repositorio.getById(i);
		Opcional opcional = repositorioOpcional.getById(o);
		total = auto.getPrecioFinal()+opcional.getPrecio();
		auto.setPrecioFinal(total);
		auto.getOpcionales().add(opcional);
		return repositorio.save(auto);
	}
	
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}

}

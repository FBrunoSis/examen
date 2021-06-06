package com.fbruno.prueba.persistencia;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fbruno.prueba.dominio.Automovil;


public interface AutomovilRepositorio extends JpaRepository<Automovil, Integer>{
	
}

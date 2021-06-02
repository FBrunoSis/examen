package com.fbruno.prueba.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbruno.prueba.dominio.Opcional;


public interface OpcionalRepositorio extends JpaRepository<Opcional, Integer>{

}

package com.fbruno.prueba.dominio;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Table(name = "opcional")
@Data
public class Opcional {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String codigo;
	private String nombre;
	private double precio;
    
    @ManyToMany(mappedBy = "opcionales")
	private List<Automovil> automoviles;
	
	public List<Automovil> getAutomoviles() {
		return automoviles;
	}


	public void setAutomoviles(List<Automovil> automoviles) {
		this.automoviles = automoviles;
	}


	public Integer getId() {
		return this.id;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	

}

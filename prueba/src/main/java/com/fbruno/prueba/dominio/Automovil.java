package com.fbruno.prueba.dominio;

import java.util.Set;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table(name = "automovil")
@Data
public class Automovil {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private double precio;
	private double precioFinal;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "automovil_opcional", joinColumns = 
    @JoinColumn(name = "automovil_id", referencedColumnName = "id"), inverseJoinColumns = 
    @JoinColumn(name = "opcional_id", referencedColumnName = "id"))
  	private Set<Opcional> opcionales;
    
	public Integer getId() {
		return this.id;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Set<Opcional> getOpcionales() {
		return opcionales;
	}

	public void setOpcionales(Set<Opcional> opcionales) {
		this.opcionales = opcionales;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	

}


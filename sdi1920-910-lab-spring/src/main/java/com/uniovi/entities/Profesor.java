package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Profesor {
	
	@Id
	@GeneratedValue
	private Long id;
	private String DNI;
	private String nombre;
	private String apellidos;
	private String categoria;
	
	public Profesor(Long id, String dNI, String nombre, String apellidos, String categoria) {
		super();
		this.id=id;
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria = categoria;
	}
	public Profesor() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Profesor [id="+id+",DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellidos + ", categoria="+categoria+"]";
	}

}

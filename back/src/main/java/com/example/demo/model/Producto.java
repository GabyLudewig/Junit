package com.example.demo.model;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="SYPRODUCTO")
public class Producto {
	
	@Id
	private Long pro_id;
	
	private String pro_nombre;
	private String pro_descripcion;
	private Long pro_existencia;
	private String pro_precio;
	
	
	public Producto() {
		
	}
	
	public Producto(Long pro_id, String pro_nombre, String pro_descripcion, Long pro_existencia, String pro_precio) {
		this.pro_id = pro_id;
		this.pro_nombre = pro_nombre;
		this.pro_descripcion = pro_descripcion;
		this.pro_existencia = pro_existencia;
		this.pro_precio = pro_precio;
		
		
	}
	public Long getPro_id() {
		return pro_id;
	}
	public void setPro_id(Long pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_nombre() {
		return pro_nombre;
	}
	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	public void setPro_descripcion(String pro_descripcion) {
		this.pro_descripcion = pro_descripcion;
	}
	public Long getPro_existencia() {
		return pro_existencia;
	}
	public void setPro_existencia(Long pro_existencia) {
		this.pro_existencia = pro_existencia;
	}
	public String getPro_precio() {
		return pro_precio;
	}
	public void setPro_precio(String pro_precio) {
		this.pro_precio = pro_precio;
	}
	
	
	
	

}

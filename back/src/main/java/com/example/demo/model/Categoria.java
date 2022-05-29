package com.example.demo.model;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name="SYCATEGORIA")
@Data
public class Categoria {
	
	@Id
	private Long cat_id;
	
	private String cat_nombre;
	private String cat_descripcion;
	
	
	public Categoria() {
		
	}
	
	public Categoria(Long cat_id, String cat_nombre, String cat_descripcion, Long cat_existencia, String cat_precio) {
		this.cat_id = cat_id;
		this.cat_nombre = cat_nombre;
		this.cat_descripcion = cat_descripcion;
				
	}
	
	public Long getCat_id() {
		return cat_id;
	}
	public void setCat_id(Long cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_nombre() {
		return cat_nombre;
	}
	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}
	public String getCat_descripcion() {
		return cat_descripcion;
	}
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

}
